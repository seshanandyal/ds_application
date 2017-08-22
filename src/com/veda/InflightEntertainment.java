package com.veda;

import java.util.HashSet;
import java.util.Set;

public class InflightEntertainment {
	public static void main(String[] args) {
		int[] movieLengthArr = {50, 135, 140, 10, 110, 90, 175, 120}; 
		int flightLength = 130;
		System.out.printf("Movies exist for flight length %d is %b \n", flightLength, 
				moviesExists(flightLength, movieLengthArr));
		flightLength = 60;
		System.out.printf("Movies exist for flight length %d is %b \n", flightLength, 
				moviesExists(flightLength, movieLengthArr));
		flightLength = 1100;
		System.out.printf("Movies exist for flight length %d is %b \n", flightLength, 
				moviesExists(flightLength, movieLengthArr));
	}
	
	static boolean moviesExists(int flightLength, int[] movieLengthArr) {
		//First attempt: Used HashMap - with keys being the movie length. However, I did not consider
		// that there could be two movies with the same length.
		Set<Integer> residueMovieLengthSet = new HashSet<>();
		
		for(int index = 0; index < movieLengthArr.length; index++) {
			int residueMovieLength = flightLength - movieLengthArr[index];
			if(residueMovieLengthSet.contains(residueMovieLength)) {
				return true;
			}
			
			residueMovieLengthSet.add(movieLengthArr[index]);
		}
		
		return false;
	}
}
