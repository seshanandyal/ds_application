package com.veda.string;

public class StringPermutatonChecker {
	public static void main(String[] args) {
		String string1 = "adroit";
		String string2 = "rditob";
		
		System.out.printf("\'%s\' and \'%s\' are permutations of each other: %b", 
				string1, string2, isAPermutation(string1, string2));
	}

	static boolean isAPermutation(String string1, String string2) {
		if(string1 == null || string2 == null || string1.length() != string2.length()) {
			return false;
		}
		
		int result = 0;
		for(char ch: string1.toCharArray()) {
			int ascii = (int) ch;
			result ^= ascii;
		}
		
		for(char ch: string2.toCharArray()) {
			int ascii = (int) ch;
			result ^= ascii;
		}
		
		return result == 0 ? true : false;
	}
}
