package com.veda;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWords {
	static final char SPACE = ' ';

	public static void main(String[] args) {
		String message = "find you will pain only go you recordings security the into if";
		System.out.printf("Reverse of: %s \n %s \n", message, reverseWords(message));
	}

	static String reverseWords(String message) {
		if (message == null || message.length() == 0) {
			return message;
		}

		// reverse the entire string in place
		message = reverseWordsInPlace(message.toCharArray());
		
		char[] array = message.toCharArray();
		int beginIndex = 0, endIndex = 0;
		for (char ch : array) {
			boolean reachedEnd = (endIndex == (array.length - 1));
			if (ch == SPACE || reachedEnd) {
				if(reachedEnd) {
					reverseCharArrayInPlace(array, beginIndex, endIndex);
				} else {
					reverseCharArrayInPlace(array, beginIndex, endIndex-1);
					beginIndex = ++endIndex;
				}
			} else {
				endIndex++;
			}
		}

		return new String(array);
	}

	static void reverseCharArrayInPlace(char[] array, int beginIndex, int endIndex) {
		while (beginIndex < endIndex) {
			char ch = array[beginIndex];
			array[beginIndex] = array[endIndex];
			array[endIndex] = ch;
			beginIndex++;
			endIndex--;
		}
	}

	static String reverseWordsInPlace(char[] array) {
		int beginIndex = 0, endIndex = array.length - 1;

		reverseCharArrayInPlace(array, beginIndex, endIndex);

		return new String(array);
	}

	// First attempt
	static String reverseWordsUsingStack(String message) {
		Stack<String> stack = new Stack<>();
		StringTokenizer tokenizer = new StringTokenizer(message);
		while (tokenizer.hasMoreTokens()) {
			stack.push(tokenizer.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.empty()) {
			sb.append(stack.pop()).append(" ");
		}

		return sb.toString();
	}
}
