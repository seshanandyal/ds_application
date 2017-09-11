package com.veda;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Steps {
	public static void main(String[] args) {
		int[] possibleSteps = { 1, 2, 3 };
		int totalSteps = 12;
		possibleStepsCombinations(totalSteps, possibleSteps);
	}

	static void possibleStepsCombinations(int totalSteps, int[] possibleSteps) {
		Queue<Set<Integer>> possibleCombinationSet = new LinkedList<>();
		for(int possibleStep: possibleSteps) {
			while(!possibleCombinationSet.isEmpty()) {
				Set<Integer> combination = possibleCombinationSet.remove();
				if(combination.contains(possibleStep)) {
					break;
				}
				Set<Integer> newCombination = new HashSet<>();
				newCombination.addAll(combination);
				newCombination.add(possibleStep);
				
				possibleCombinationSet.add(combination);
				possibleCombinationSet.add(newCombination);
				
			}
			Set<Integer> newCombination = new HashSet<>();
			newCombination.add(possibleStep);
			possibleCombinationSet.add(newCombination);
		}
		
		System.out.printf("The total number of valid combination of steps is %d \n", 
				validCombinations(totalSteps, possibleCombinationSet));
	}

	static int validCombinations(int totalSteps, Queue<Set<Integer>> possibleCombinationSteps) {
		int validCombinationCount = 0;
		StringBuilder sb = null;
		
		for(Set<Integer> combination: possibleCombinationSteps) {
			System.out.println(combination);
			int stepCount = totalSteps;
			sb = new StringBuilder();
			
			Queue<Integer> stepQueue = new LinkedList<>();
			for(int step: combination) {
				stepQueue.add(step);
			}
			
			while(stepCount != 0) {
				int step = stepQueue.remove();
				sb.append(step + " ");
				if(stepCount < 0) {
					break;
				}
				
				stepCount -= step;
				stepQueue.add(step);
			}
			if(stepCount == 0) {
				System.out.println(sb.toString());
				validCombinationCount++;
			} 
		}
		return validCombinationCount;
	}
}
