/**
 * Given  strings. Each string contains only lowercase letters from (both inclusive). The set of  strings is 
 * said to be GOOD SET if no string is prefix of another string else, it is BAD SET. (If two strings are identical, 
 * they are considered prefixes of each other.)
 * For example, aab, abcde, aabcd is BAD SET because aab is prefix of aabcd.
 * Print GOOD SET if it satisfies the problem requirement. 
 * Else, print BAD SET and the first string for which the condition fails.
 * 
 * @author Sesha Shayan Nandyal
 */

package com.veda.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoPrefixSet {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i]   = scan.next();
        }
        
        TrieInternal trie = new TrieInternal();
        String badSetString = null;
        for(String string: arr) {
            if(!trie.insert(string)) {
                badSetString = string;
                break;
            }
        }
        
        if(badSetString != null) {
            System.out.println("BAD SET");
            System.out.println(badSetString);
        } else {
            System.out.println("GOOD SET");
        }
        
        scan.close();
    }
}

class TrieInternal {
    TrieNodeInternal mRoot;
    
    public boolean insert(String string) {
        if(string == null || string.length() == 0) {
            return false;
        }
        
        if(mRoot == null) {
            mRoot = new TrieNodeInternal();
        }
        
        int numberOfCharsLeft = string.length();
        TrieNodeInternal current = mRoot;
        for(char ch: string.toCharArray()) {
            TrieNodeInternal node = current.mTrieNodeMap.get(ch);
            if(node == null) {
                node = new TrieNodeInternal();
                current.mTrieNodeMap.put(ch, node);
            } else {
                if(node.mEndOfString || numberOfCharsLeft == 1) {
                    return false;
                }
            }
            current = node;
            numberOfCharsLeft--;
        }
        current.mEndOfString = true;
        return true;
    }
}

class TrieNodeInternal {
    Map<Character, TrieNodeInternal> mTrieNodeMap = new HashMap<>();
    boolean mEndOfString;
    
    public String toString() {
        return mTrieNodeMap.toString();
    }
}

