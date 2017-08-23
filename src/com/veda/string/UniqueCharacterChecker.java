/**
 * Checking for unqiueness of characters in a string
 * 
 * @author Sesha Nandyal
 */
package com.veda.string;

import java.util.Arrays;

public class UniqueCharacterChecker {
	final static char CHARACTER_A = 'a';
	
	public static void main(String[] args) {
		String string = "adroit";
		System.out.printf("The string \'%s\' has unique characters: %b", string, checkForUniqueness(string));
		
	}
	
	static boolean checkForUniqueness(String string) {
		if(string == null || string.length() == 0 || string.length() == 1) {
			return true; //depends ...
		}
		
		char[] charArr = string.toCharArray();
		Arrays.sort(charArr);
		
		char previous = charArr[0];
		for(int index = 1; index < charArr.length; index++) {
			if(previous == charArr[index]) {
				return false;
			} else {
				previous = charArr[index];
			}
		}
		return true;
	}
}
