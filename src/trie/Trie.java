package trie;

//https://www.youtube.com/watch?v=T1M52UqQq3c
public class Trie {

	class TrieNode1 {
		TrieNode1[] children = new TrieNode1[26];
		boolean isEnd;
	}

	TrieNode1 root;

	/** Initialize your data structure here. */
	public Trie() {
		this.root = new TrieNode1();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		if (word == null || word.length() == 0) 
            return;
		
		TrieNode1 node = root;
		for (int i = 0; i < word.length(); i++) {

			char c = word.charAt(i);

			if (node.children[c - 'a'] == null)
				node.children[c - 'a'] = new TrieNode1();

			node = node.children[c - 'a'];
		}
		node.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode1 node = root;

		for (int i = 0; i < word.length(); i++) {

			char c = word.charAt(i);

			if (node.children[c - 'a'] == null)
				return false;

			node = node.children[c - 'a'];
		}

		return node.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode1 node = root;

		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (node.children[c - 'a'] == null)
				return false;

			node = node.children[c - 'a'];
		}
		return true;
	}

	public static void main(String[] args) {
		Trie obj = new Trie();
		obj.insert("apple");
		obj.insert("apple");
		obj.insert("apple");
		boolean param_2 = obj.search("jd");
		boolean param_3 = obj.startsWith("ap");

		System.out.println(param_2 + " " + param_3);
	}

}
