/**
 * Steve has a string, , consisting of  lowercase English alphabetic letters. In one operation, 
 * he can delete any pair of adjacent letters with same value. For example, string "aabcc" would 
 * become either "aab" or "bcc" after operation. Steve wants to reduce  as much as possible. To do this, 
 * he will repeat the above operation as many times as it can be performed. Help Steve out by 
 * finding and printing 's non-reducible form!
 * Note: If the final string is empty, print Empty String .
 * 
 * @author Sesha Shayan Nandyal
 */
package com.veda.hacker.string;

import java.util.Scanner;
import java.util.Stack;

public class SuperReducedString {
	static final String EMPTY_STRING = "Empty String";

    static String super_reduced_string(String s){
        if(s == null || s.length() == 0) {
            return EMPTY_STRING;
        }
        
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(!stack.empty()) {
                char lastCharacter = stack.peek();
                if(lastCharacter == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        char[] arr = sb.toString().toCharArray();
        
        for(int index = 0; index < (arr.length/2); index++) {
            char temp = arr[index];
            arr[index] = arr[arr.length - index -1];
            arr[arr.length-index-1] = temp;
        }
        
        String str = new String(arr);
        if("".equals(str)) {
            return EMPTY_STRING;
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
