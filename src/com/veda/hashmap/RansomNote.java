/**
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know 
 * if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in 
 * his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or 
 * concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note 
exactly using whole words from the magazine; otherwise, print No.
* @author Sesha Shayan Nandyal
 */

package com.veda.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class RansomNote {
	Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RansomNote(String magazine, String note) {
        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(magazine);
        while(tokenizer.hasMoreTokens()) {
            String magString = tokenizer.nextToken();
            Integer count = magazineMap.get(magString);
            if(count == null) {
                magazineMap.put(magString, 1);
            } else {
                magazineMap.put(magString, ++count);
            }
        }
        
        noteMap = new HashMap<>();
        tokenizer = new StringTokenizer(note);
        while(tokenizer.hasMoreTokens()) {
            String noteString = tokenizer.nextToken();
            Integer count = noteMap.get(noteString);
            if(count == null) {
                noteMap.put(noteString, 1);
            } else {
                noteMap.put(noteString, ++count);
            }
        }
    }
    
    public boolean solve() {
        Set<String> noteWords = noteMap.keySet();
        for(String note: noteWords) {
            if(magazineMap.get(note) == null) {
                return false;
            }
            
            if(noteMap.get(note) > magazineMap.get(note)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
