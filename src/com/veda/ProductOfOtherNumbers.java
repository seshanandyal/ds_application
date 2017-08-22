package com.veda;

public class ProductOfOtherNumbers {
	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 5, 6, 4};
		for(int number: arr) {
			System.out.print(number + " ");
		}
		System.out.println();
				
		getProductsOfAllIntsExceptAtIndex(arr);
		
		for(int number: arr) {
			System.out.print(number + " ");
		}
	}
	
	static void getProductsOfAllIntsExceptAtIndex(int[] arr) {
		int[] productBeforeIndexArr = new int[arr.length];
		int[] productAfterIndexArr = new int[arr.length];
		
		for(int index = 0; index < arr.length; index++) {
			productBeforeIndexArr[index] = 1;
			productAfterIndexArr[index] = 1;
		}
		
		for(int index = 0; index < arr.length; index++) {
			if(index !=  (arr.length - 1)) {
				productBeforeIndexArr[index + 1] = productBeforeIndexArr[index] * arr[index];
				
			}
		}
		
		for(int index = arr.length - 1; index > 0; index--) {
			if(index != 0) {
				productAfterIndexArr[index - 1] = productAfterIndexArr[index] * arr[index];
			}
		}
		
		for(int index = 0; index < arr.length; index++) {
			arr[index] = productBeforeIndexArr[index] * productAfterIndexArr[index];
		}
	}
}
