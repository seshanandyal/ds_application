package com.veda.linkedlist;

public class LinkedListNode {
	private int mValue;
	private LinkedListNode mNext;
	
	public LinkedListNode(int value) {
		mValue = value;
	}

	public int getValue() {
		return mValue;
	}


	public LinkedListNode getNext() {
		return mNext;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object != null && !(object instanceof LinkedListNode)) {
			return false;
		}
		
		LinkedListNode node = (LinkedListNode) object;
		return mValue == node.getValue();
	}
	
	@Override
	public int hashCode() {
		return new Integer(mValue).hashCode();
	}

	public void setNext(LinkedListNode next) {
		mNext = next;
	}

	public void setValue(int value) {
		mValue = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(mValue);
	}
}
