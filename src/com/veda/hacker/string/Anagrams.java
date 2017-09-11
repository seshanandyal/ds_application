package com.veda.hacker.string;

/**
 * Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be 
 * anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, 
 * both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, 
 * but bacdc and dcbad are not. Alice decides on an encryption scheme involving two large strings where 
 * encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help 
 * her find this number? Given two strings,  and , that may or may not be of the same length, determine the 
 * minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.
 * 
 * @author Sesha Shayan Nandyal
 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Anagrams {
    public static int numberNeeded(String first, String second) {
        if("".equals(first) || "".equals(second)) {
            return 0;
        }
        
        Map<Character, Integer> firstCharCountMap = new HashMap<>();
        for(char ch: first.toCharArray()) {
            Integer count = firstCharCountMap.get(ch);
            if(count == null) {
                firstCharCountMap.put(ch, 1);
            } else {
                firstCharCountMap.put(ch, ++count);
            }
        }
        
        Map<Character, Integer> secondCharCountMap = new HashMap<>();
        for(char ch: second.toCharArray()) {
            Integer count = secondCharCountMap.get(ch);
            if(count == null) {
                secondCharCountMap.put(ch, 1);
            } else {
                secondCharCountMap.put(ch, ++count);
            }
        }
        
        Set<Character> charSet = new HashSet<>();
        
        for(char ch: firstCharCountMap.keySet()) {
            charSet.add(ch);
        }
        for(char ch: secondCharCountMap.keySet()) {
            charSet.add(ch);
        }
        
        int countOfCharsToBeRemoved = 0;
        for(char ch: charSet) {
            if(!firstCharCountMap.keySet().contains(ch)) {
                countOfCharsToBeRemoved += secondCharCountMap.get(ch);
                continue;
            }
            if(!secondCharCountMap.keySet().contains(ch)) {
                countOfCharsToBeRemoved += firstCharCountMap.get(ch);
                continue;
            }
            
            Integer firstCount = firstCharCountMap.get(ch);
            Integer secondCount = secondCharCountMap.get(ch);
            
            int difference = (firstCount > secondCount) ? firstCount - secondCount: secondCount - firstCount;
            countOfCharsToBeRemoved += difference;
        }
        
        return countOfCharsToBeRemoved;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}