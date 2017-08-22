package com.veda;

public class ReverseStringInPlace {
	public static void main(String[] args) {
		String string = "immutable";
		
		System.out.printf("Reverse of %s is %s \n", string, reverseStringInPlace(string));
		
	}
	
	static String reverseStringInPlace(String string) {
		if(string == null || string.length() == 0) {
			return string;
		}
		
		char[] array = string.toCharArray();
		int beginIndex = 0, endIndex = array.length - 1;
		
		while(beginIndex < endIndex) {
			char ch = array[beginIndex];
			array[beginIndex] = array[endIndex];
			array[endIndex] = ch;
			beginIndex++;
			endIndex--;
		}
		
		return new String(array);
	}
}
