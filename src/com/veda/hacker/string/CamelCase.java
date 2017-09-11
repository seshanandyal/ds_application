/**
 * Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:
 * It is a concatenation of one or more words consisting of English letters.
 * All letters in the first word are lowercase. For each of the subsequent words, the first letter 
 * is uppercase and rest of the letters are lowercase. Given , print the number of words in  on a new line.
 * @author Sesha Shayan Nandyal
 */
package com.veda.hacker.string;

import java.util.Scanner;

public class CamelCase {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        
        //Assume s is not null or an empty string
        int numberOfWords = 1;
        for(char ch: s.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                numberOfWords++;
            }
        }
        System.out.println(numberOfWords);
    }
}
