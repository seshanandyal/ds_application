/**
 * Given two linked lists, check if they have a common segment
 * @author Sesha Shayan Nandyal
 */

package com.veda.linkedlist;

public class LinkedListIntersectionFinder {
	LinkedList mList1 = null;
	LinkedList mList2 = null;
		
	void createTest() {
		LinkedList common = new LinkedList();
		common.insert(8);
		common.insert(4);
		common.insert(6);
		
		mList1 = new LinkedList();
		mList1.insert(5);
		mList1.insert(10);
		mList1.insert(1);
		mList1.insert(57);
		
		LinkedListNode current = mList1.mHead;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(common.mHead);
		
		mList2 = new LinkedList();
		mList2.insert(44);
		mList2.insert(23);
		
		current = mList2.mHead;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(common.mHead);
		
		mList1.display();
		mList2.display();
	}
	
	private boolean intersectionNodeExists() {
		if(mList1 == null || mList2 == null) {
			return false;
		}
		
		int list1Length = 0, list2Length = 0;
		
		LinkedListNode currentList1 = mList1.mHead, currentList2 = mList2.mHead;
		while(currentList1.getNext() != null) {
			list1Length++;
			currentList1 = currentList1.getNext();
		}
		
		currentList2 = mList2.mHead;
		while(currentList2.getNext() != null) {
			list2Length++;
			currentList2 = currentList2.getNext();
		}
		
		if(currentList1 != currentList2) {
			return false;
		}
		
		if(list1Length > list2Length) {
			int shortenLongerList = list1Length - list2Length;
			currentList1 = mList1.mHead;
			while(shortenLongerList >= 1) {
				currentList1 = currentList1.getNext();
				shortenLongerList--;
			}
			mList1.mHead = currentList1;
		} else if(list2Length > list1Length) {
			int shortenLongerList = list2Length - list1Length;
			currentList2 = mList2.mHead;
			while(shortenLongerList >= 1) {
				currentList2 = currentList2.getNext();
				shortenLongerList--;
			}
			mList2.mHead = currentList2;
		}
		
	    currentList1 = mList1.mHead;
	    currentList2 = mList2.mHead;
	    
	    while(currentList1 != null && currentList1 != currentList2) {
	    	currentList1 = currentList1.getNext();
	    	currentList2 = currentList2.getNext();
	    }
	    
		return currentList1 == currentList2;
	}
	
	
	public static void main(String[] args) {
		LinkedListIntersectionFinder finder = new LinkedListIntersectionFinder();
		finder.createTest();
		System.out.println("The above two linked lists intersect: " + finder.intersectionNodeExists());
	}
	
	class LinkedList {
		private LinkedListNode mHead;
		
		void insert(int value) {
			LinkedListNode newNode = new LinkedListNode(value);
			
			if(mHead == null) {
				mHead = newNode;
				return;
			}
			
			LinkedListNode current = mHead;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			
			current.setNext(newNode);
		}
		
		void display() {
			LinkedListNode current = mHead;
			while(current != null) {
				System.out.print(current + " -> ");
				current = current.getNext();
			}
			System.out.println("null");
		}
	}
}