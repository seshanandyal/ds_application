package com.veda;

import java.util.Stack;

public class QueueWithTwoStacks {
	private Stack<Character> mEnQueueStack;
	private Stack<Character> mDeQueueStack;
	
	public QueueWithTwoStacks() {
		mEnQueueStack = new Stack<>();
		mDeQueueStack = new Stack<>();
	}
	
	public void enqueue(char character) {
		mEnQueueStack.push(character);
	}
	
	public char dequeue() throws QueueWithTwoStacksException {
		if(mEnQueueStack.isEmpty() && mDeQueueStack.isEmpty()) {
			throw new QueueWithTwoStacksException("Queue is empty.");
		}
		
		if(mDeQueueStack.isEmpty()) {
			while(!mEnQueueStack.isEmpty()) {
				mDeQueueStack.push(mEnQueueStack.pop());
			}
		}
		
		return mDeQueueStack.pop();
	}
	
	public static void main(String[] args) throws QueueWithTwoStacksException {
		QueueWithTwoStacks queue = new QueueWithTwoStacks();
		queue.enqueue('a');
		queue.enqueue('b');
		queue.enqueue('c');
		System.out.println(queue.dequeue());
		queue.enqueue('d');
		System.out.println(queue.dequeue());
		queue.enqueue('e');
		System.out.println(queue.dequeue());
		queue.enqueue('f');
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}

class QueueWithTwoStacksException extends Exception {
	public QueueWithTwoStacksException() {
		super();
	}
	
	public QueueWithTwoStacksException(String message) {
		super(message);
	}
}
