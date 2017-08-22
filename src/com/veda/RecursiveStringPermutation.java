package com.veda;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RecursiveStringPermutation {
	public static void main(String[] args) {
		String str = "adroit";
		Set<String> permutatedSet = recursivePermutation(str);
		for(String permutatedString: permutatedSet) {
			System.out.println(permutatedString);
		}
	}
	
	static Set<String> recursivePermutation(String str) {
		if(str == null) {
			return null;
		}
		
		if(str.length() <= 1) {
			return new HashSet<>(Arrays.asList(str));
		}
		
		String subStringTillLastCharacter = str.substring(0, str.length() - 1);
		String lastCharacter = str.substring(str.length() - 1);
		
		Set<String> permutatedSubStringTillLastCharacterSet = 
				recursivePermutation(subStringTillLastCharacter);
		Set<String> permutatedSet = new HashSet<>();
		for(String perumtatedString: permutatedSubStringTillLastCharacterSet) {
			for(int index = 0; index <= perumtatedString.length(); index++) {
				StringBuilder sb = new StringBuilder(perumtatedString.substring(0, index))
						.append(lastCharacter)
						.append(perumtatedString.substring(index));
				permutatedSet.add(sb.toString());
			}
		}
		
		return permutatedSet;
	}
}
