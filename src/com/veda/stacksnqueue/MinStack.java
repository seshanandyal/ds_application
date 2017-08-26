 
/**
Performs the stack operations and the min() returns the largest element in the stack in O(1)
 * @author Sesha Shayan Nandyal
 */

package com.veda.stacksnqueue;

import java.util.Stack;

public class MinStack {
	Stack<Integer> mStack;
	Stack<Integer> mMinStack;
	
	public MinStack() {
		mStack = new Stack<>();
		mMinStack = new Stack<>();
	}
	
	public void push(int value) {
		mStack.push(value);
		
		if(mMinStack.isEmpty() || mMinStack.peek() >= value) {
			mMinStack.push(value);
		}
	}
	
	public int pop() {
		int item = mStack.pop();
		if(item == mMinStack.peek()) {
			mMinStack.pop();
		}
		return item;
	}
	
	public int min() throws StackEmptyException {
		if(mMinStack.isEmpty()) {
			throw new StackEmptyException("Stack is empty.");
		}
		
		return mMinStack.peek();
	}
	
	@Override
	public String toString() {
		return mStack.toString();
	}
	
	public static void main(String[] args) throws StackEmptyException{
		MinStack minStack
		= new MinStack();
		
		minStack.push(5);
		minStack.push(16);
		minStack.push(3);
		
		System.out.println(minStack);
		
		System.out.println("Min: " + minStack.min());
		
		minStack.pop();
		System.out.println(minStack);
		
		System.out.println("Min: " + minStack.min());
	}
	
	class StackEmptyException extends Exception {
		String mMessage;
		
		StackEmptyException() {
			super();
		}
		
		StackEmptyException(String message) {
			super(message);
			mMessage = message;
		}
	}
}
