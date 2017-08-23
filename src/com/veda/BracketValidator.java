/**
 * BracketValidator - validates if every opening parenthesis/braces/brackets has its corresponding 
 * parenthesis/braces/brackets.
 * 
 * @author Sesha Shayan Nandyal
 */

package com.veda;

import java.util.HashMap;
import java.util.Stack;

public class BracketValidator {
	
	static final char LEFT_PARENTHESIS = '(';
	static final char RIGHT_PARENTHESIS = ')';
	static final char LEFT_SQUARE_BRACKET = '[';
	static final char RIGHT_SQUARE_BRACKET = ']';
	static final char LEFT_BRACES = '{';
	static final char RIGHT_BRACES = '}';
	
	static final HashMap<Character, Character> LEFT_RIGHT_BRACKET_MAP = new HashMap<>();
	static {
		LEFT_RIGHT_BRACKET_MAP.put(LEFT_PARENTHESIS, RIGHT_PARENTHESIS);
		LEFT_RIGHT_BRACKET_MAP.put(LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET);
		LEFT_RIGHT_BRACKET_MAP.put(LEFT_BRACES, RIGHT_BRACES);
	}
	
	public static void main(String[] args) {
		String example1 = "{ [ ] ( ) }";
		String example2 = "{ [ ( ] ) }";
		String example3 = "{ [ }";
		
		System.out.printf("Result of %s is %b \n",  example1, validateBrackets(example1));
		System.out.printf("Result of %s is %b \n",  example1, validateBrackets(example2));
		System.out.printf("Result of %s is %b \n",  example1, validateBrackets(example3));
	}
	
	static boolean validateBrackets(String string) {
		if(string == null || string.length() == 0) {
			return true;
		}
		
		char[] array = string.toCharArray();
		Stack<Character> stack = new Stack<>();
		
		for(char ch: array) {
			if(ch == LEFT_PARENTHESIS || ch == LEFT_SQUARE_BRACKET ||
					ch == LEFT_BRACES) {
				stack.push(ch);
			} else if(ch == RIGHT_PARENTHESIS || ch == RIGHT_SQUARE_BRACKET ||
					ch == RIGHT_BRACES) {
				if(stack.isEmpty()) {
					return false;
				} else {
					char poppedChar = stack.pop();
					if(ch != LEFT_RIGHT_BRACKET_MAP.get(poppedChar)) {
						return false;
					}
				}
			}
		}
		
		return stack.isEmpty();
	}
}
