/**
 * Implementation of Boyer Moore Algorithm - to search a pattern in a given word.
 * 
 * @author Sesha Shayan Nandyal
 */

package com.veda.string;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoorePatternFinder {
	private Map<Character, Integer> mBadMapTable;
	private int mPatternLength;
	
	public BoyerMoorePatternFinder() {
		mBadMapTable = new HashMap<Character, Integer>();
	}
	
	public static void main(String[] args) {
		BoyerMoorePatternFinder finder = new BoyerMoorePatternFinder();
		
		String word = "this is a test";
		String pattern = "test";
		System.out.printf("The pattern \'%s\' is contained in the string, \'%s\' is %b \n", 
				pattern, word, finder.search(word, pattern));
		
		word = "abcbcfgm";
		pattern = "bcfg";
		System.out.printf("The pattern \'%s\' is contained in the string, \'%s\' is %b \n", 
				pattern, word, finder.search(word, pattern));
		
		word = "abcbcfgm";
		pattern = "bfgm";
		System.out.printf("The pattern \'%s\' is contained in the string, \'%s\' is %b \n", 
				pattern, word, finder.search(word, pattern));
		
	}
	
	private void constructMap(String pattern) {
		for(int index = 0; index < pattern.length(); index++) {
			char ch = pattern.charAt(index);
			mBadMapTable.put(ch, Math.max(1, pattern.length() - index - 1));
		}
	}
	
	private int shiftToRightBy(Character ch) {
		Integer moveToRightBy = mBadMapTable.get(ch);
		if(mBadMapTable.get(ch) != null) {
			return moveToRightBy;
		} else {
			return mPatternLength;
		}
	}
	
	public boolean search(String word, String pattern) {
		if(word == null || pattern == null || 
				word.length() == 0 || pattern.length() == 0 || 
				word.length() < pattern.length()) {
			return false;
		}
		word = word.toLowerCase();
		pattern = pattern.toLowerCase();
		
		mPatternLength = pattern.length();
		constructMap(pattern);
				
		int wordIndex = mPatternLength - 1, patternIndex = mPatternLength - 1, 
				wordCounter = mPatternLength - 1;
		
		while(wordIndex < word.length()) {
			char wordChar = word.charAt(wordCounter);
			char patternChar = pattern.charAt(patternIndex);
			if(wordChar == patternChar) {
				wordCounter--;
				patternIndex--;
			} else {
				wordIndex = wordIndex + shiftToRightBy(wordChar);
				patternIndex = mPatternLength - 1;
				wordCounter = wordIndex;
			}
			
			if(patternIndex < 0) {
				break;
			}
		}
		
		if(patternIndex < 0) {
			return true;
		} else {
			return false;
		}
	}
}
