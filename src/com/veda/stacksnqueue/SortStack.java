/**
 * Sort elements of a stack in ascending order using a variable and another stack.
 * @author Sesha Shayan Nandyal
 */
package com.veda.stacksnqueue;

import java.util.Stack;

public class SortStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(12);
		stack.push(5);
		stack.push(10);
		stack.push(1);
		stack.push(8);
		stack.push(3);
		stack.push(7);
		
		System.out.println("Stack before sort: " + stack);
		Stack<Integer> sortedStack = sort(stack);
		
		if(sortedStack == null) {
			System.out.println("Stack is empty.");
		} else {
			System.out.println("Stack after sort: " + sortedStack);
		}
	}
	
	public static Stack<Integer> sort(Stack<Integer> unSortedStack) {
		if(unSortedStack.empty()) {
			return null;
		}
		
		Stack<Integer> sortedStack = new Stack<>();
		
		while(!unSortedStack.empty()) {
			if(sortedStack.isEmpty()) {
				sortedStack.push(unSortedStack.pop());
				continue;
			}
			
			if(unSortedStack.peek() < sortedStack.peek()) {
				sortedStack.push(unSortedStack.pop());
			} else {
				int tempUnsortedElement = unSortedStack.pop();
				int tempSortedElement;
								
				int firstSortedStackElement = sortedStack.peek();
				boolean isFirstElement = true;
				
				while(!sortedStack.empty() 
						&& tempUnsortedElement > sortedStack.peek()) {
					
					tempSortedElement = sortedStack.pop();;
					if(isFirstElement) {
						firstSortedStackElement = tempSortedElement;
						isFirstElement = false;
					}
					unSortedStack.push(tempSortedElement);
				}
				
				sortedStack.push(tempUnsortedElement);
				while(firstSortedStackElement != unSortedStack.peek()) {
					sortedStack.push(unSortedStack.pop());
				}
			}
		}
				
		return sortedStack;
	}
}
