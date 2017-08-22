package com.veda;

import java.util.Stack;

public class MatchingParenthesisValidator {
	static final char LEFT_PARENTHESIS = '(';
	static final char RIGHT_PARENTHESIS = ')';

	public static void main(String[] args) {
		String str = "Sometimes (when I nest them (my parentheticals) too much "
				+ "(like this (and this))) they get confusing.";

		boolean stringHasMatchingParenthesis = parenthesisValidator(str);

		if (stringHasMatchingParenthesis) {
			System.out.printf("The string \"%s\" has matching parenthesis.\n", str);
		} else {
			System.out.printf("The string \"%s\" does not have a matching parenthesis. \n", str);
		}

	}

	static boolean parenthesisValidator(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}

		int leftParenthesisCounter = 0;
		char[] array = str.toCharArray();

		for (char ch : array) {
			if (ch == LEFT_PARENTHESIS) {
				leftParenthesisCounter++;
			} else if (ch == RIGHT_PARENTHESIS) {
				if (leftParenthesisCounter == 0) {
					return false;
				}
				leftParenthesisCounter--;
			}
		}

		if (leftParenthesisCounter != 0) {
			return false;
		} else {
			return true;
		}
	}

	// First attempt - Using O(m) additional space. m is the number of
	// left parenthesis
	static boolean parenthesisValidatorUsingStack(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}

		Stack<Character> stack = new Stack<>();
		char[] array = str.toCharArray();

		for (char ch : array) {
			if (ch == LEFT_PARENTHESIS) {
				stack.push(ch);
			} else if (ch == RIGHT_PARENTHESIS) {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}

		if (!stack.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
