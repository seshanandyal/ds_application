package com.veda.string;

import java.util.ArrayList;
import java.util.List;

public class PermutationPalindromeChecker {
	public static void main(String[] args) {
		String example1 = "civic";
		String example2 = "ivicc";
		String example3 = "civil";
		String example4 = "livci";
		
		System.out.printf("Result of %s is %b \n", example1, checkPermutationPalindrome(example1));
		System.out.printf("Result of %s is %b \n", example2, checkPermutationPalindrome(example2));
		System.out.printf("Result of %s is %b \n", example3, checkPermutationPalindrome(example3));
		System.out.printf("Result of %s is %b \n", example4, checkPermutationPalindrome(example4));
	}
	
	static boolean checkPermutationPalindrome(String string) {
		if(string == null || string.length() == 0) {
			return true; //Assumption: Empty or null string is a palindrome
		}
		
		boolean stringLengthIsEven = (string.length() %2 == 0) ? true: false;
		List<Character> characterList = new ArrayList<>();
		
		for(char ch: string.toCharArray()) {
			if(characterList.contains(ch)) {
				int index = characterList.indexOf(ch);
				characterList.remove(index);
			} else {
				characterList.add(ch);
			}
		}
		
		if(stringLengthIsEven) {
			return characterList.isEmpty();
		} else {
			return characterList.size() == 1;
		}
	}
}
