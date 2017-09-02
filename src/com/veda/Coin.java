/**
 * Coin class implements the following functionality given:
 * an amount of money
 * an array of coin denominations
 * computes the number of ways to make the amount of money with coins of the available denominations.
 */

package com.veda;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//Partially correct - need to revisit this code.
public class Coin {
	static List<Integer> sDenominationList;

	public static void main(String[] args) {
		Integer[] denominations = { 1, 3, 5 };
		int amount = 5;

		denominationCombination(amount, denominations);
	}

	static void denominationCombination(int amount, Integer[] denominations) {
		Queue<Set<Integer>> possibleDenomiationCombinationSet = new LinkedList<>();
		for (int denomination : denominations) {
			while (!possibleDenomiationCombinationSet.isEmpty()) {
				Set<Integer> denominationSet = possibleDenomiationCombinationSet.remove();
				if (denominationSet.contains(denomination)) {
					break;
				}
				Set<Integer> newDenominationSet = new HashSet<>();
				newDenominationSet.addAll(denominationSet);
				newDenominationSet.add(denomination);

				possibleDenomiationCombinationSet.add(denominationSet);
				possibleDenomiationCombinationSet.add(newDenominationSet);
			}
			Set<Integer> newDenominationSet = new HashSet<>();
			newDenominationSet.add(denomination);
			possibleDenomiationCombinationSet.add(newDenominationSet);
		}

		for (Set<Integer> denominationSet : possibleDenomiationCombinationSet) {
			isValidCombinationSet(amount, denominationSet);
		}
	}

	static boolean isValidCombinationSet(int amount, Set<Integer> combinationSet) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		for (int denomination : combinationSet) {
			queue.add(denomination);
		}

		while (amount != 0) {
			if (amount < 0) {
				return false;
			}
			int denomination = queue.remove();
			amount = amount - denomination;
			sb.append(denomination + "c" + " ");
			queue.add(denomination);
		}
		System.out.println(sb.toString());
		return true;
	}
}
