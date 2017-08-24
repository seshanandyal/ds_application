/**
 * OneEditAwayFinder checks if two strings are one edit away.
 * @author Sesha Shayan Nandyal
 */

package com.veda.string;

public class OneEditAwayFinder {
	public static void main(String[] args) {
		System.out.printf("%s, %s -> %b \n",  "pale", "ple", isOneEditAway("pale", "ple"));
		System.out.printf("%s, %s -> %b \n",  "pales", "pale", isOneEditAway("pales", "pale"));
		System.out.printf("%s, %s -> %b \n",  "pale", "bale", isOneEditAway("pale", "bale"));
		System.out.printf("%s, %s -> %b \n",  "pale", "bake", isOneEditAway("pale", "bake"));
	}
	
	static boolean isOneEditAway(String string1, String string2) {
		if(string1 == null || string2 == null || 
				string1.length() == 0 || string2.length() == 0 ||
				(string1.length() - string2.length() > 1)) {
			System.out.println("Either the strings are null or they are empty strings "
					+ "or they are not of the same length or there");
			return false;
		}
		
		if(string1.length() == string2.length()) {
			return compareTwoEqualStrings(string1, string2);
		} else {
			if(string1.length() > string2.length()) {
				return compareTwoUnequalStrings(string1, string2);
			} else {
				return compareTwoUnequalStrings(string2, string1);
			}
		}
	}
	
	static boolean compareTwoUnequalStrings(String longerString, String shorterString) {
		boolean diffAlreadyExists = false;
		
		int shorterIndex = 0;
		for(int longerIndex = 0; 
				(longerIndex < longerString.length() && shorterIndex < shorterString.length()); 
				longerIndex++) {
			if(longerString.charAt(longerIndex) != 
					shorterString.charAt(shorterIndex)) {
				if(diffAlreadyExists) {
					return false;
				}
				System.out.printf("First: %c, %c \n", longerString.charAt(longerIndex), 
						shorterString.charAt(shorterIndex));
				diffAlreadyExists = true;
			} else {
				shorterIndex++;
			}
		}
		
		return true;
	}
	
	static boolean compareTwoEqualStrings(String string1, String string2) {
		boolean diffAlreadyExists = false;
		
		for(int index = 0; index < string1.length(); index++) {
			if(string1.charAt(index) != string2.charAt(index)) {
				if(diffAlreadyExists) {
					return false;
				} else {
					diffAlreadyExists = true;
				}
			}
		}
		
		return true;
	}
}
