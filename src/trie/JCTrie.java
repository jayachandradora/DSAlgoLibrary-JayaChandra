package trie;
//https://www.youtube.com/watch?v=fhyIORFDD0k ....Find here trie wiht prefix(LCP)
public class JCTrie {

	TrieNode root = null;

	public static void main(String[] args) {

		JCTrie obj = new JCTrie();
		obj.insert("apple");
		System.out.println("Search apple : " + obj.search("apple"));
		System.out.println("prefix : " + obj.prefix("app"));
		System.out.println("Search app word " + obj.search("app"));
	}

	JCTrie() {
		root = new TrieNode();
	}

	public void insert(String word) {

		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {

			char c = word.charAt(i);

			if (node.children[c - 'a'] == null)
				node.children[c - 'a'] = new TrieNode();

			node = node.children[c - 'a'];
		}
		node.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode node = root;

		for (int i = 0; i < word.length(); i++) {

			char c = word.charAt(i);

			if (node.children[c - 'a'] == null)
				return false;

			node = node.children[c - 'a'];
		}

		return node.isEnd;
	}

	boolean prefix(String prefix) {
		TrieNode node = root;

		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (node.children[c - 'a'] == null)
				return false;

			node = node.children[c - 'a'];
		}
		return true;
	}
}

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	boolean isEnd;
}