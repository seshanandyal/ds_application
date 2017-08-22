package com.veda;

public class FindRotationPoint {
	public static void main(String[] args) {
		String[] words = new String[]{
				    "ptolemaic",
				    "retrograde",
				    "supplant",
				    "undulate",
				    "xenoepist",
				    "asymptote", // <-- rotates here!
				    "babka",
				    "banoffee",
				    "engender",
				    "karpatka",
				    "othellolagkage",
		};
		int rotationPoint = getRotationPointIndex(words);
		System.out.println("The rotation point is at: " + rotationPoint + " and the word is: " +
					words[rotationPoint]);
	}
	
	static int getRotationPointIndex(String[] words) {
		if(words == null || words.length == 0) {
			return -1;
		}
		int beginIndex = 0, endIndex = words.length - 1;
		
		String firstArrayElement = words[0];
		
		while(beginIndex < endIndex) {
			int rotationPoint = beginIndex + (endIndex - beginIndex)/2;
			if(firstArrayElement.compareTo(words[rotationPoint]) > 0) {
				endIndex = rotationPoint;
			} else if(firstArrayElement.compareTo(words[rotationPoint]) < 0) {
				beginIndex = rotationPoint;
				firstArrayElement = words[beginIndex];
			}
			
			if(beginIndex + 1 == endIndex) {
				break;
			}
		}

		
		return endIndex;
	}
}
