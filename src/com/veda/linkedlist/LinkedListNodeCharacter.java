package com.veda.linkedlist;

public class LinkedListNodeCharacter {
	private Character mValue;
	private LinkedListNodeCharacter mNext;
	
	public LinkedListNodeCharacter(Character value) {
		mValue = value;
	}

	public Character getValue() {
		return mValue;
	}


	public LinkedListNodeCharacter getNext() {
		return mNext;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object != null && !(object instanceof LinkedListNodeCharacter)) {
			return false;
		}
		
		LinkedListNodeCharacter node = (LinkedListNodeCharacter) object;
		return mValue.equals(node.getValue());
	}
	
	@Override
	public int hashCode() {
		return mValue.hashCode();
	}

	public void setNext(LinkedListNodeCharacter next) {
		mNext = next;
	}
	
	public String toString() {
		return String.valueOf(mValue);
	}
}
