package com.veda;

public class ReverseLinkedList {
	private Node mHead;
	
	public void insert(Node node) {
		if(mHead == null) {
			mHead = node;
			return;
		}
		
		Node current = mHead;
		while(current.mNext != null) {
			current = current.mNext;
		}
		current.mNext = node;
	}
	
	public void display() {
		Node current = mHead;

		while(current != null) {
			System.out.print(current + " -> ");
			current = current.mNext;
		}
		System.out.println("null");
	}
	
	public void reverse() {
		if(mHead == null || mHead.mNext == null) {
			return;
		}
		
		Node previous = mHead, current = mHead.mNext, future = mHead.mNext;
		previous.mNext = null;
		while(current.mNext != null) {
			future = current.mNext;
			current.mNext = previous;
			previous = current;
			current = future;			
		}
		current.mNext = previous;
		mHead = future;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		list.insert(new Node(1));		
		list.insert(new Node(2));
		list.insert(new Node(3));
		list.insert(new Node(4));
		
		list.display();
		
		list.reverse();
		
		list.display();
	}
	
	static class Node {
		int mValue;
		Node mNext;
		
		Node(int value) {
			mValue = value;
		}
		
		public String toString() {
			return Integer.toString(mValue);
		}
	}
}