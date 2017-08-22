package com.veda;

import java.util.Arrays;

public class NumberAppearingTwiceFinder {
	static final int POSSIBLE_NUMBER_COUNT = 100;
	static final int DUPLICATE_NUMBER = 57;
	
	public static void main(String[] args) throws InputArrayException {
		 
		int[] arr = new int[POSSIBLE_NUMBER_COUNT + 1];
		for(int index = 0; index < POSSIBLE_NUMBER_COUNT + 1; index++) {
			arr[index] = index + 1;
		}
		
		arr[POSSIBLE_NUMBER_COUNT] = DUPLICATE_NUMBER;
		
		System.out.printf("The input array has a duplicate number %d\n", findNumberAppearingTwice(arr));
	}
	
	
	static int findNumberAppearingTwice(int[] array) throws InputArrayException {
		if(array == null || array.length <= 1) {
			throw new InputArrayException("The input array is null or has only one element.");
		}
		
		int sumOfNNumbers = (POSSIBLE_NUMBER_COUNT * POSSIBLE_NUMBER_COUNT + POSSIBLE_NUMBER_COUNT)/2;
		
		int sum = 0;
		for(int number:array) {
			sum = sum + number;
		}
		
		
		return (sum - sumOfNNumbers);
	}
	
	//First attempt: O(logn) time complexity
	static int findNumberAppearingTwiceBySorting(int[] array) throws InputArrayException {
		if(array == null || array.length <= 1) {
			throw new InputArrayException("The input array is null or has only one element.");
		}
		
		Arrays.sort(array);
		
		int previous = array[0];
		for(int index = 1; index < array.length; index++) {
			if(array[index] == previous) {
				return previous;
			}
			previous = array[index];
		}
		throw new InputArrayException("Input array has no duplicates.");
	}
	
	static class InputArrayException extends Exception {
		public InputArrayException() {
			super();
		}
		
		public InputArrayException(String message) {
			super(message);
		}
	}
}
