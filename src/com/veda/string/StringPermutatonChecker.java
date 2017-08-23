package com.veda.string;

public class StringPermutatonChecker {
	public static void main(String[] args) {
		String string1 = "adroit";
		String string2 = "rditoa";
		
		System.out.printf("\'%s\' and \'%s\' are permutations of each other: %b", 
				string1, string2, isAPermutation(string1, string2));
	}

	static boolean isAPermutation(String string1, String string2) {
		if(string1 == null || string2 == null || string1.length() != string2.length()) {
			return false;
		}
		
		return (xorEachCharacter(string1) ^ xorEachCharacter(string2)) == 0 ? true: false;
		
	}
	
	static int xorEachCharacter(String string) {
		int result = 0;
		for(char ch: string.toCharArray()) {
			int ascii = (int) ch;
			result ^= ascii;
		}
		return result;
	}
}
