/**
 * Queue using two stacks.
 * @author Sesha Shayan Nandyal
 */
package com.veda.stacksnqueue;

import java.util.Scanner;
import java.util.Stack;

public class QueueWithTwoStacks {
	public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if(stackOldestOnTop.isEmpty()) {
                if(stackNewestOnTop.isEmpty()) {
                    return null;
                } else {
                    while(!stackNewestOnTop.empty()) {
                        stackOldestOnTop.push(stackNewestOnTop.pop());
                    }
                    return stackOldestOnTop.peek();
                }
            } else {
                return stackOldestOnTop.peek();
            }
        }

        public T dequeue() {
            if(peek() == null) {
                while(!stackNewestOnTop.empty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            T popped = stackOldestOnTop.pop();
            return popped;
        }
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
