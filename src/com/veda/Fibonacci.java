/**
 * Generates Fibonacci numbers
 * 
 * @author Sesha Shayan Nandyal
 */
package com.veda;


public class Fibonacci {
	public static void main(String[] args) throws InvalidNumberException {
		int number = 6;
		System.out.printf("fib(%d) is %d \n", number, fibonacci(number));	
	}
	
	static int fibonacci(int number) throws InvalidNumberException {
		if(number < 0) {
			throw new InvalidNumberException("Number cannot be negative.");
		}
		
		if(number == 0 || number == 1) {
			return number;
		}
		
		int previousOfPrevious = 0, previous = 1;
		for(int counter = 2; counter <= number; counter++) {
			int current = previousOfPrevious + previous;
			previousOfPrevious = previous;
			previous = current;
		}
		
		return previous;
		
	}
	
	//First Attempt - O(2^n)
	static int fibonacciRecursive(int number) throws InvalidNumberException {
		if(number < 0) {
			throw new InvalidNumberException("Number cannot be negative.");
		}
		
		if(number == 0 || number == 1) {
			return number;
		} else {
			return fibonacci(number - 1) + fibonacci(number - 2);
		}
	}
}

class InvalidNumberException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNumberException() {
		super();
	}
	
	public InvalidNumberException(String message) {
		super(message);
	}
}
