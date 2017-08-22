package com.veda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighestProductOfThreeNumbers {
	static List<Integer> sLeastThreeNegativeIntegerList = new ArrayList<>();
	static List<Integer> sLeastTwoNegativeIntegerList = new ArrayList<>();
	
	static int sLargestNumber;
	static List<Integer> sGreatestTwoNonNegativeIntegerList = new ArrayList<>();
	static List<Integer> sGreatestThreeNonNegativeIntegerList = new ArrayList<>();
	
	public static void main(String[] args) {
		int[] arrayOfInts = {-10, -10, 1, 3, 2};
		
		sortDataAndThenCompute(arrayOfInts); //O(n logn) time complexity
		highestProductOfThreeNumbers(arrayOfInts); //O(n) time complexity and O(1) space complexity
	}
	
	static void highestProductOfThreeNumbers(int[] arrayOfInts) {
		if(arrayOfInts.length < 3) {
			System.out.println("Length of the array cannot be less than 3");
			return;
		}
		
		if(arrayOfInts.length == 3) {
			int product = 1;
			for(int number: arrayOfInts) {
				product = product * number;
			}
			System.out.println("Highest product of three numbers in the array is: " + product);
			return;
		}
		
		for(int number: arrayOfInts) {
			if(number < 0) {
				addToLeastThreeNegativeIntegerList(number);
				addToLeastTwoNegativeIntegerList(number);
			} else {
				addToGreatestThreeNonNegativeIntegerList(number);
				addToGreatestTwoNonNegativeIntegerList(number);
			}
		}
		
		int productOfLeastNumbers = 1;
		if(sLeastTwoNegativeIntegerList.size() == 2) {
			for(int number: sLeastTwoNegativeIntegerList) {
				productOfLeastNumbers = productOfLeastNumbers * number;
			}
			int productOfLargestTwoNumbers = 1;
			for(int number: sGreatestTwoNonNegativeIntegerList) {
				productOfLargestTwoNumbers = productOfLargestTwoNumbers * number;
			}
			
			if(productOfLeastNumbers > productOfLargestTwoNumbers) {
				System.out.println("Highest product of three numbers in the array is: " + 
							productOfLeastNumbers * sLargestNumber);
				return;
			}
		}
		
		int product = 1;
		for(int number: sGreatestThreeNonNegativeIntegerList) {
			product = product * number;
		}
		System.out.println("Highest product of three numbers in the array is: " + 
				product);
		
		return;
	}
	
	static boolean addToGreatestThreeNonNegativeIntegerList(int number) {
		if(sLargestNumber < number) {
			sLargestNumber = number;
		}
		
		if(sGreatestThreeNonNegativeIntegerList.size() == 0 || 
				sGreatestThreeNonNegativeIntegerList.size() < 3) {
			sGreatestThreeNonNegativeIntegerList.add(number);
			return true;
		}
		
		for(int index = 0; index < sGreatestThreeNonNegativeIntegerList.size(); index++) {
			if(number > sGreatestThreeNonNegativeIntegerList.get(index)) {
				sGreatestThreeNonNegativeIntegerList.remove(index);
				sGreatestThreeNonNegativeIntegerList.add(index, number);
				return true;
			}
		}
		
		return false;
	}
	
	static boolean addToGreatestTwoNonNegativeIntegerList(int number) {
		if(sLargestNumber < number) {
			sLargestNumber = number;
		}
		
		if(sGreatestTwoNonNegativeIntegerList.size() == 0 || 
				sGreatestTwoNonNegativeIntegerList.size() < 2) {
			sGreatestTwoNonNegativeIntegerList.add(number);
			return true;
		}
		
		for(int index = 0; index < sGreatestTwoNonNegativeIntegerList.size(); index++) {
			if(number > sGreatestTwoNonNegativeIntegerList.get(index)) {
				sGreatestTwoNonNegativeIntegerList.remove(index);
				sGreatestTwoNonNegativeIntegerList.add(index, number);
				return true;
			}
		}
		
		return false;
	}
	
	static boolean addToLeastThreeNegativeIntegerList(int number) {
		if(sLeastThreeNegativeIntegerList.size() == 0 ||
				sLeastThreeNegativeIntegerList.size() < 3) {
			sLeastThreeNegativeIntegerList.add(number);
			return true;
		}
		
		for(int index = 0; index < sLeastThreeNegativeIntegerList.size(); index++) {
			if(number < sLeastThreeNegativeIntegerList.get(index)) {
				sLeastThreeNegativeIntegerList.remove(index);
				sLeastThreeNegativeIntegerList.add(number);
				return true;
			}
		}
		
		return false;
	}
	
	static boolean addToLeastTwoNegativeIntegerList(int number) {
		if(sLeastTwoNegativeIntegerList.size() == 0 ||
				sLeastTwoNegativeIntegerList.size() < 2) {
			sLeastTwoNegativeIntegerList.add(number);
			return true;
		}
		
		for(int index = 0; index < sLeastTwoNegativeIntegerList.size(); index++) {
			if(number < sLeastTwoNegativeIntegerList.get(index)) {
				sLeastTwoNegativeIntegerList.remove(index);
				sLeastTwoNegativeIntegerList.add(number);
				return true;
			}
		}
		
		return false;
	}
	
	
	//O(nlogn)
	static void sortDataAndThenCompute(int[] arrayOfInts) {
		Arrays.sort(arrayOfInts);
		int size = arrayOfInts.length;
		int product = 1;
		
		if(arrayOfInts[0] < 0 && arrayOfInts[1] < 0) {
			if((arrayOfInts[0] * arrayOfInts[1]) > arrayOfInts[size - 1] * arrayOfInts[size - 2]) {
				product = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[size - 1];
			}
		} else {
			for(int index = size - 1; index > size - 4; index--) {
				product = product * arrayOfInts[index];
			}
		}		
		
		System.out.println("Highest product of three numbers in the array is: " + product);
	}
}
