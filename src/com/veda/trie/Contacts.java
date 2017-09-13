/**
 * We're going to make our own Contacts application! The application must perform two types of operations:
 * add name, where  is a string denoting a contact name. This must store  as a new contact in the application. 
 * find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting 
 * with  and print the count on a new line.Given  sequential add and find operations, perform each operation in order.
 * @author Sesha Shayan Nandyal
 */

package com.veda.trie;

import java.util.Scanner;
import java.util.*;

public class Contacts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String operation = scan.next();
            String contact   = scan.next();
            if ("add".equals(operation)) {
                trie.add(contact);
            } else if ("find".equals(operation)) {
                trie.find(contact);
            }
        }
        scan.close();
    }
}

class Trie {
    private TrieNode mRoot;
    
    public void add(String name) {
        if(name == null || "".equals(name)) {
            return;
        }
        if(mRoot == null) {
            mRoot = new TrieNode();
        }
        
        TrieNode current = mRoot;
        for(char ch: name.toCharArray()) {
            TrieNode node = current.mTrieNodeMap.get(ch);
            if(node == null) {
                node = new TrieNode();
            }
            node.mNumberOfPrefixes++;
            current.mTrieNodeMap.put(ch, node);
            current = node;
        }
        current.mIsEndOfString = true;
    }
    
    public void find(String partial) {
        if(mRoot == null || "".equals(partial)) {
            System.out.println("0");
            return;
        }
        
        TrieNode current = mRoot;
        for(char ch: partial.toCharArray()) {
            TrieNode node = current.mTrieNodeMap.get(ch);
            if(node == null) {
                System.out.println("0");
                return;
            }
            current = node;
        }
        System.out.println(current.mNumberOfPrefixes);
    }   
}

class TrieNode {
    Map<Character, TrieNode> mTrieNodeMap = new HashMap<>();
    boolean mIsEndOfString;
    int mNumberOfPrefixes;  
}