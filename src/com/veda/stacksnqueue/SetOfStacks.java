/**
 * This class implements a List of stacks that behave like a Stack.
 * @author Sesha Shayan Nandyal
 */

package com.veda.stacksnqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
	private List<Stack<Integer>> mStackList;
	static final int STACK_THRESHOLD = 2;
	
	public SetOfStacks() {
		mStackList = new ArrayList<>();
	}
	
	public void push(int value) {		
		Stack<Integer> lastStack = getLastStack();
		
		if(lastStack != null && lastStack.size() < STACK_THRESHOLD) {
			lastStack.push(value);
		} else {
			//Create a new stack
			Stack<Integer> newStack = new Stack<>();
			newStack.push(value);
			mStackList.add(newStack);
		}
	}
	
	private Stack<Integer> getLastStack() {
		if(mStackList.isEmpty()) {
			return null;
		} else {
			return mStackList.get(mStackList.size() - 1);
		}
	}
	
	public int pop() throws SetOfStacksEmptyException {
		Stack<Integer> lastStack = getLastStack();
		if(lastStack == null) {
			throw new SetOfStacksEmptyException("The set of stacks is empty.");
		}
		
		int value = lastStack.pop();
		if(lastStack.size() == 0) {
			mStackList.remove(mStackList.size() - 1);
		}
		
		return value;
	}
	
	public static void main(String[] args) throws SetOfStacksEmptyException {
		SetOfStacks setOfStacks = new SetOfStacks();
		
		setOfStacks.push(12);
		setOfStacks.push(5);
		setOfStacks.push(10);
		setOfStacks.push(1);
		setOfStacks.push(8);
		setOfStacks.push(3);
		setOfStacks.push(7);
		
		System.out.println(setOfStacks.pop());
	}
	
	class SetOfStacksEmptyException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String mMessage;
		
		SetOfStacksEmptyException() {
			super();
		}
		
		SetOfStacksEmptyException(String message) {
			super(message);
			mMessage = message;
		}
	}
}
