package trie;

import java.util.ArrayList;
import java.util.List;

public class TestTrie {

	TrieNode11 root = null;

	TestTrie() {
		root = new TrieNode11();
	}

	public void insert(String word) {

		TrieNode11 node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (node.children[ch - 'a'] == null)
				node.children[ch - 'a'] = new TrieNode11();

			node.wordCount = node.wordCount + 1;
			node = node.children[ch - 'a'];

		}
		node.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode11 node = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (node.children[ch - 'a'] == null)
				return false;

			node = node.children[ch = 'a'];
		}
		return node.isEnd;
	}

	List<Character> prefix(String word) {
		List<Character> prefix = new ArrayList<Character>();
		TrieNode11 node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (node.children[ch - 'a'] == null || node.isEnd == true)
				return prefix;
			else {
				prefix.add(ch);
				node = node.children[ch - 'a'];
			}
		}
		return prefix;
	}
	
	public int prefixLength() {
		TrieNode11 node = root;
		int maxLen = 0;
		while(node != null) {
			maxLen = maxLen + 1;
			node = root;
		}
		return maxLen;
	}

	public static void main(String[] args) {

		TestTrie tt = new TestTrie();
		String strs[] = {"apples", "apple", "app", "apps"};
		for(String str : strs)
			tt.insert(str);
		
		
	}

}

class TrieNode11 {
	TrieNode11[] children = new TrieNode11[26];
	boolean isEnd = false;
	int wordCount = 0;
}