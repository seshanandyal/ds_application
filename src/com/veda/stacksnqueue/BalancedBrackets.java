/*
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs 
 * to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of 
 * matched pairs of brackets: [], {}, and ().
 * @author Sesha Shayan Nandyal
 */

package com.veda.stacksnqueue;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    static final char OPEN_PAREN = '(';
    static final char CLOSE_PAREN = ')';
    static final char OPEN_BRACES = '{';
    static final char CLOSE_BRACES = '}';
    static final char OPEN_SQUARE_BRACKET = '[';
    static final char CLOSE_SQUARE_BRACKET = ']';
    
    public static boolean isBalanced(String expression) {
        if("".equals(expression)) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        for(char ch: expression.toCharArray()) {
            if(ch == OPEN_PAREN || ch == OPEN_BRACES || ch == OPEN_SQUARE_BRACKET) {
                stack.push(ch);
            } else {
                if(ch == CLOSE_PAREN) {
                    if(stack.isEmpty() || stack.pop() != OPEN_PAREN) {
                        return false;
                    }
                } else if(ch == CLOSE_BRACES) {
                    if(stack.isEmpty() || stack.pop() != OPEN_BRACES) {
                        return false;
                    }
                } else if (ch == CLOSE_SQUARE_BRACKET) {
                    if(stack.isEmpty() || stack.pop() != OPEN_SQUARE_BRACKET) {
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}