package com.veda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Partially correct - need to revisit this code.
public class Coin {
	static List<Integer> sDenominationList;

	public static void main(String[] args) {
		Integer[] denominations = { 1, 2, 3 };
		int amount = 4;
		possibleChangeCombinations(amount, denominations);
		//denominationCombination(amount, denominations);
		//changePossibilitiesBottomUp(amount, denominations);
	}

	static void denominationCombination(int amount, Integer[] denominations) {
		sDenominationList = new ArrayList<>(Arrays.asList(denominations));
		Collections.sort(sDenominationList);

		StringBuilder outputBuilder = new StringBuilder();
		for (int index = sDenominationList.size() - 1; index >= 0; index--) {

			String output = findCountForADenomination(amount, sDenominationList.get(index));
			if (output != null) {
				outputBuilder.append(output).append("\n");
			}
		}
		System.out.println(outputBuilder.toString());
	}

	static String findCountForADenomination(int amount, int denomination) {
		if (denomination > amount && amount != 0) {
			return null;
		}

		int quotient = amount / denomination;
		int remainder = amount % denomination;

		// System.out.println("quotient: " + quotient + ", amount: " + amount +
		// ", denomination: " + denomination);

		StringBuilder sb = new StringBuilder();
		for (int count = 1; count <= quotient; count++) {
			sb.append(denomination + "c ");
		}

		if (remainder == 0) {
			return sb.toString();
		}

		String output = null;
		for (int index = 0; (index < sDenominationList.size() - 1) && (remainder != 0); index++) {
			int denom = sDenominationList.get(index);
			if (denom > remainder) {
				sb = null;
				break;
			}
			output = findCountForADenomination(remainder, denom);
			if (output != null) {
				sb.append(output);
				break;
			}
		}

		if (sb != null) {
			return sb.toString();
		} else {
			return null;
		}
	}
	
	static void possibleChangeCombinations(int amount, Integer[] denominations) {
		List<Integer> deonminationList = Arrays.asList(denominations);
		Collections.sort(deonminationList);
		
		int initialAmount = amount;
		boolean stopLookingForChange = false;
		
		StringBuilder sb = new StringBuilder();
		
		for(int index = 0; index < deonminationList.size() && amount != 0; index++) {
			int denomination = sDenominationList.get(index);
			
			if(amount < denomination) {
				break;
			}
			
			amount = amount - denomination;
			sb.append(denomination + "c ");
			
		}
	
	}

	static int changePossibilitiesBottomUp(int amount, int[] denominations) {
		int[] waysOfDoingNCents = new int[amount + 1]; // array of zeros from
														// 0..amount
		waysOfDoingNCents[0] = 1;

		for (int coin : denominations) {
			for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
				int higherAmountRemainder = higherAmount - coin;
				waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
				System.out.println(higherAmount + ", " + amount);
			}
		}
		System.out.println(waysOfDoingNCents[amount]);

		return waysOfDoingNCents[amount];
	}
}
