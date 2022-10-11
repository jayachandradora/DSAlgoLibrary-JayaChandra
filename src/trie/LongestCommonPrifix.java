package trie;

public class LongestCommonPrifix {

	public static void main(String[] args) {

		String strs[] = { "abcdxyz", "abcdlll", "abcddddd" };
		System.out.println(longestCommonPrefix(strs));
	}

	static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		trieN trie = new trieN();
		for (String s : strs)
			trie.insert(s);

		node root = trie.root;
		int prefixLength = 0;

		for (int i = 0; i < strs[0].length(); i++) {
			int idx = strs[0].charAt(i) - 97;

			if (root.children[idx].count != strs.length)
				return strs[0].substring(0, prefixLength);
			
			prefixLength++;
			root = root.children[idx];
		}
		return strs[0].substring(0, prefixLength);
	}
}

class trieN {
	node root;

	trieN() {
		root = new node();
	}

	void insert(String word) {
		node curr = root;

		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 97;

			if (curr.children[idx] == null)
				curr.children[idx] = new node();
			
			curr = curr.children[idx];

			curr.count += 1;
		}
	}
}

class node {
	node[] children;
	boolean isEnd;
	int count;

	node() {
		children = new node[26];
		isEnd = false;
		count = 0;
	}
}