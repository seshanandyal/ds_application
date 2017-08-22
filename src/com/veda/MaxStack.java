package com.veda;

import java.util.Stack;

public class MaxStack  {
	private Stack<Integer> mStack;
	private Stack<Integer> mMaxStack;
	
	public MaxStack() {
		mStack = new Stack<>();
		mMaxStack = new Stack<>();
	}
	
	public void push(int number) {
		mStack.push(number);
		if(mMaxStack.isEmpty() || mMaxStack.peek() <= number) {
			mMaxStack.push(number);
		}
	}
	
	public int pop() {
		int number = mStack.pop();
		if(mMaxStack.peek() == number) {
			mMaxStack.pop();
		}
		return number;
	}
	
	public int getMax() {
		return mMaxStack.peek();
	}
	
	public String toString() {
		return mStack.toString();
	}
	
	public static void main(String[] args) {
		MaxStack maxStack = new MaxStack();
		
		maxStack.push(5);
		maxStack.push(16);
		
		System.out.println(maxStack);
		
		System.out.println("Max: " + maxStack.getMax());
		
		maxStack.pop();
		System.out.println(maxStack);
		
		System.out.println("Max: " + maxStack.getMax());
	}
	
}
