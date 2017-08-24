/**
 * Remove duplicates from an unsorted linked list.
 * @author Sesha Shayan Nandyal
 */
package com.veda.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DuplicateRemover {
	private LinkedListNode mHead;
	
	public void insert(int value) {
		LinkedListNode newNode = new LinkedListNode(value);
		if(mHead == null) {
			mHead = newNode;
		} else {
			LinkedListNode current = mHead;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}
	
	public void removeDuplicates() {
		Set<LinkedListNode> set = new HashSet<>();
		LinkedListNode current = mHead, previous = mHead;
		while(current != null) {
			if(set.contains(current)) {
				if(previous == mHead) {
					mHead = null;
					break;
				} else {
					previous.setNext(current.getNext());
					current = current.getNext();
				}
			} else {
				set.add(current);
				previous = current;
				current = current.getNext();
			}
		}
	}
	
	public void display() {
		LinkedListNode current = mHead;
		if (current == null) {
			System.out.println("The linked list is empty.");
		} else {
			while (current != null) {
				System.out.print(current.getValue() + "  ");
				current = current.getNext();
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		DuplicateRemover remover = new DuplicateRemover();
		remover.insert(45);
		remover.insert(23);
		remover.insert(46);
		remover.insert(45);
		remover.insert(23);
		
		remover.removeDuplicates();
		
		remover.display();
	}
}
