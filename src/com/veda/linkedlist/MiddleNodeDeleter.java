/**
 * Deletes a specific middle node from a linkedlist
 * @author Sesha Shayan Nandyal
 */
package com.veda.linkedlist;

/*
 * Delete a node from a singly linked list given only a variable pointing to that node.
 */
public class MiddleNodeDeleter {
	private Node mHead;
	
	public void insert(Node node) {
		if(mHead == null) {
			mHead = node;
		} else {
			Node current = mHead;
			while(current.mNext != null) {
				current = current.mNext;
			}
			current.mNext = node;
		}
	}
	
	public void delete(Node node) {
		//Assumption: the node that is passed is not null and it exists in the linked list.
		if(node.mNext != null) { //It is not the last node
			node.mValue = node.mNext.mValue;
			node.mNext = node.mNext.mNext;
		} else {
			Node current = mHead;
			if(current == node) {
				mHead = current.mNext;
				return;
			}
			
			while(current.mNext.mValue != node.mValue) {
				current = current.mNext;
			}
			current.mNext = null;
		}
	}
	
	public void display() {
		Node current = mHead;
		while(current != null) {
			System.out.print(current.mValue + " -> ");
			current = current.mNext;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		
		MiddleNodeDeleter list = new MiddleNodeDeleter();
		list.insert(a);
		list.insert(b);
		list.insert(c);
		
		list.display();
		
		list.delete(b);
		list.display();
		
		list.delete(c);
		list.display();
	}
	
	static class Node {
		String mValue;
		Node mNext;
		
		Node(String value) {
			mValue = value;
		}
	}
}


