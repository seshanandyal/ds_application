package com.veda.hacker.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ThreeElementSumToTarget {
	static Integer[] displayTriplets(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int number:  arr) {
			map.put(number, number);
		}
		
		for(int outerIndex = 0; outerIndex < arr.length; outerIndex++) {
			for(int innerIndex = outerIndex + 1; innerIndex < arr.length; innerIndex++) {
				Set<Integer> set = new HashSet<>();
				int sum = 0;
				set.add(arr[outerIndex]);
				sum += arr[outerIndex];
				set.add(arr[innerIndex]);
				sum += arr[innerIndex];
				if(map.get(target - sum) != null) {
					set.add(target - sum);
					Integer[] out = new Integer[3];
					return set.toArray(out);
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		int[] arr = { -2, 3, 5, -8, 9};
		int target = 6;
		
		Integer[] out = displayTriplets(arr, target);
		if(out != null) {
			for(int number: out) {
				System.out.print(number + " ");
			}
		}
	}
}
