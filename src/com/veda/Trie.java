package com.veda;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Trie {
	private TrieNode mRoot;

	public Trie() {
		mRoot = new TrieNode();
	}

	public void insert(String word) {
		if (word == null || word.length() == 0) {
			return;
		}

		TrieNode current = mRoot;
		for (int index = 0; index < word.length(); index++) {
			char ch = word.charAt(index);
			TrieNode node = current.mChildrenMap.get(ch);
			if(node == null) {
				node = new TrieNode();
				current.mChildrenMap.put(ch, node);
			}
			current = node;
		}
		current.mEndOfWord = true;
	}
	
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		
		TrieNode current = mRoot;
		for(int index = 0; index < word.length(); index++) {
			char ch = word.charAt(index);
			TrieNode node = current.mChildrenMap.get(ch);
			if(node == null) {
				return false;
			}
			current = node;
		}
		
		return current.mEndOfWord;
	}
	
	public void delete(String word) {
		if(word == null || word.length() == 0) {
			return;
		}
		
		TrieNode current = mRoot;
		Stack<TrieNode> stack = new Stack<>();
		
		for(int index = 0; index < word.length(); index++) {
			char ch = word.charAt(index);
			TrieNode node = current.mChildrenMap.get(ch);
			if(node == null) {
				System.out.printf("String %s is not present. Cannot delete.\n", word);
				return;
			}
			stack.push(current);
			current = node;
		}
		
		if(!current.mEndOfWord) {
			System.out.printf("%s is not a complete word. It is a prefix of another word. \n", word);
			return;
		}
		
		for(int index = (word.length() - 1); index >= 0; index--) {
			char ch = word.charAt(index);
			current = stack.pop();
			TrieNode child = current.mChildrenMap.get(ch);
			if(child.mEndOfWord) {
				current.mChildrenMap.remove(ch);
				if(current.mChildrenMap.isEmpty()) {
					current.mEndOfWord = true;
				}
			} else {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("abgl");
		trie.insert("cdf");
		trie.insert("abcd");
		trie.insert("lmn");
		
		System.out.printf("%s exists %b \n", "abc", trie.search("abc"));
		System.out.printf("%s exists %b \n", "ab", trie.search("ab"));
		System.out.printf("%s exists %b \n", "lmn", trie.search("lmn"));
		System.out.printf("%s exists %b \n", "ghi", trie.search("ghi"));
		System.out.printf("%s exists %b \n", "cdf", trie.search("cdf"));
		
		trie.delete("ab");
		System.out.printf("%s exists %b \n", "abc", trie.search("abc"));
		System.out.printf("%s exists %b \n", "abgl", trie.search("abgl"));
	}
}

class TrieNode {
	Map<Character, TrieNode> mChildrenMap;
	boolean mEndOfWord;

	public TrieNode() {
		mChildrenMap = new HashMap<>();
		mEndOfWord = false;
	}
	
	public String toString() {
		return "EndOfWord: " + mEndOfWord + " map: "  + mChildrenMap.toString();
	}
}
