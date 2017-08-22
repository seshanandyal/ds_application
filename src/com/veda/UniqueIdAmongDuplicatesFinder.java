package com.veda;

import java.util.ArrayList;
import java.util.List;

public class UniqueIdAmongDuplicatesFinder {
	public static void main(String[] args) {
		int[] deliveryIdConfirmations = {23,3,23, 56, 3};
		System.out.printf("Missing id: %d\n", findUniqueIdAmongDuplicates(deliveryIdConfirmations));
	}
	
	static int findUniqueIdAmongDuplicates(int[] deliveryIdConfirmations) {
		//Assumption: deliverIdConfirmations is not null or had only one unique element
		// and delivery ids are positive integers.
		
		int uniqueId = 0;
		for(int deliveryId: deliveryIdConfirmations) {
			uniqueId ^= deliveryId;
		}
		return uniqueId;
	}
	
	//First Attempt: Using O(n) space complexity
	static int findUniqueIdAmongDuplicatesUsingAList(int[] deliveryIdConfirmations) {
		//Assumption - that the array is not null or has only one or zero elements
		List<Integer> idList = new ArrayList<>();
		
		for(int deliveryId: deliveryIdConfirmations) {
			if(idList.contains(deliveryId)) {
				int index = idList.indexOf(deliveryId);
				idList.remove(index);
			} else {
				idList.add(deliveryId);
			}
		}
		
		return idList.get(0);
	}
}
