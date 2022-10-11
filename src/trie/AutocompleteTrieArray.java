package trie;

import java.util.ArrayList;
import java.util.List;

public class AutocompleteTrieArray {

	static final int NUM_OF_CHARS = 128;

	static class TrieNode {
		char data;
		TrieNode[] children = new TrieNode[NUM_OF_CHARS];
		boolean isEnd = false;

		// Constructor, Time O(1), Space O(1), 128 is constant
		TrieNode(char c) {
			data = c;
		}
	}

	static class Trie {
		TrieNode root = new TrieNode(' ');

		// Inserts a word into the trie, Iteration
		// Time O(s), Space O(s), s is word length
		void insert(String word) {
			TrieNode node = root;
			for (char ch : word.toCharArray()) {
				if (node.children[ch] == null)
					node.children[ch] = new TrieNode(ch);
				node = node.children[ch];
			}
			node.isEnd = true;
		}

		// find the node with prefix's last char, then call helper to find all words
		// using recursion
		// Time O(n), Space O(n), n is number of nodes included(prefix and branches)
		List<String> autocomplete(String prefix) {
			TrieNode node = root;
			List<String> res = new ArrayList<String>();
			for (char ch : prefix.toCharArray()) {
				node = node.children[ch];
				if (node == null)
					return new ArrayList<String>();
			}
			helper(node, res, prefix.substring(0, prefix.length() - 1));
			return res;
		}

		// recursion function called by autocomplete
		// Time O(n), Space O(n), n is number of nodes in branches
		void helper(TrieNode node, List<String> res, String prefix) {
			if (node == null) // base condition
				return;
			if (node.isEnd)
				res.add(prefix + node.data);
			for (TrieNode child : node.children)
				helper(child, res, prefix + node.data);
		}
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("amazon");
		t.insert("amazon prime");
		t.insert("amazing");
		t.insert("amazing spider man");
		t.insert("amazed");
		t.insert("apple");

		System.out.println(t.autocomplete("amaz"));
	}

}
