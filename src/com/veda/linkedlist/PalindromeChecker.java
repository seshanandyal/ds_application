/**
 * Palindrome checker - underlying is a linkedlist
 * @author Sesha Shayan Nandyal
 */

package com.veda.linkedlist;

public class PalindromeChecker {
	private LinkedListNodeCharacter mHead;
	
	public void insert(Character value) {
		LinkedListNodeCharacter newNode = new LinkedListNodeCharacter(value);
		
		if(mHead == null) {
			mHead = newNode;
			return;
		}
		
		LinkedListNodeCharacter current = mHead;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(newNode);
	}
	
	public void display() {
		LinkedListNodeCharacter current = mHead;

		while(current != null) {
			System.out.print(current + " -> ");
			current = current.getNext();
		}
		System.out.println("null");
	}
	
	private boolean isAPalindrome() {
		if(mHead == null) {
			return false;
		}
		
		LinkedListNodeCharacter currentReverseLinkedListNode = createClonedReversedLinkedList();	
		LinkedListNodeCharacter  current = mHead;
		
		while(current != null && (current.getValue() == currentReverseLinkedListNode.getValue())) {
			current = current.getNext();
			currentReverseLinkedListNode = currentReverseLinkedListNode.getNext();
		}
		
		return current == null;
	}
	
	private LinkedListNodeCharacter createClonedReversedLinkedList() {
		LinkedListNodeCharacter previous = null, current = mHead;
		LinkedListNodeCharacter newNode = null;
		while(current != null) {
			newNode = new LinkedListNodeCharacter(current.getValue());
			newNode.setNext(previous);
			previous = newNode;
			current = current.getNext();
		}
		
		return newNode;
	}
	
	public static void main(String[] args) {
		PalindromeChecker checker = new PalindromeChecker();
		
		String string = "malayalam";
		for(char ch: string.toCharArray()) {
			checker.insert(ch);
		}
		
		checker.display();
		System.out.printf("The string \'%s\' is a palindrome: %b \n", string, checker.isAPalindrome());
	}
}
