package com.veda;

public class TopScores {
	public static void main(String[] args) {
		int[] unsortedScores = {91, 37, 89, 41, 93, 96, 65, 91, 93,  53};
		int highestPossibleScore = 100;
		
		highestPossibleScores(highestPossibleScore, unsortedScores);
		
		System.out.print("[");
		for(int score: unsortedScores) {
			System.out.print(score + " ");
		}
		System.out.println("]");
	}
	
	static void highestPossibleScores(int highestPossibleScore, int[] unsortedScores) {
		if(unsortedScores == null || unsortedScores.length == 0) {
			return;
		}
		
		int[] sortedScores = new int[highestPossibleScore + 1];
		
		for(int score: unsortedScores) {
			if(score < highestPossibleScore) {
				sortedScores[score]++;
			}
		}
		
		int unsortedIndex = 0;
		for(int index = 0; index < sortedScores.length; index++) {
			if(sortedScores[index] !=0 ) {
				for(int count = 1; count <= sortedScores[index]; count++) {
					unsortedScores[unsortedIndex++] = index;
				}
			}
		}
	}
}
