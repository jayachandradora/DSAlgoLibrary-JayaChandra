package trie;

import java.util.ArrayList;
import java.util.List;

//JD solution
public class AutoSuggestTrieFreshWork {

	public static void main(String[] args) {
		AutoSuggestTrieFreshWork t = new AutoSuggestTrieFreshWork();
		t.insert("app", 123);
		t.insert("apple", 1234);
		t.insert("applee", 12345);
		System.out.println(t.search("apple"));
		for(Contact ct : t.autoSuggestPrefix("appl"))
			System.out.println(ct.name + " " + ct.phone);
	}

	TrieNode5 root;

	public AutoSuggestTrieFreshWork() {
		root = new TrieNode5();
	}

	public void insert(String name, int phone) {

		if (name == null || name.length() == 0) 
            return;
         
		TrieNode5 node = root;
		for (char ch : name.toCharArray()) {
			if (node.childeren[ch - 'a'] == null)
				node.childeren[ch - 'a'] = new TrieNode5();

			node = node.childeren[ch - 'a'];
		}
		node.contact = new Contact(name, phone);
		node.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode5 node = root;

		for (char ch : word.toCharArray()) {
			if (node.childeren[ch - 'a'] != null)
				node = node.childeren[ch - 'a'];
			else
				return false;
		}
		return node.isEnd;
	}

	public boolean prefix(String word) {

		TrieNode5 node = root;
		for (char ch : word.toCharArray()) {
			if (node.childeren[ch - 'a'] != null)
				node = node.childeren[ch - 'a'];
			else
				return false;
		}
		return true;
	}
	
	public List<Contact> autoSuggestPrefix(String word) {

		List<Contact> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		TrieNode5 node = root;
		for (char ch : word.toCharArray()) {
			if (node.childeren[ch - 'a'] != null) {
				node = node.childeren[ch - 'a'];
				sb.append(ch);
				if(sb.toString().equals(word))
					helper(node, list);
			}
		}
		return list;
	}
	
	public void helper(TrieNode5 node, List<Contact> contacts){
		if(node == null)
			return;
		
		if(node.isEnd)
			contacts.add(node.contact);
		
		for(TrieNode5 node1 : node.childeren) 
			helper(node1, contacts);
	}
}

class TrieNode5 {
	Contact contact;
	boolean isEnd = false;
	TrieNode5 childeren[] = new TrieNode5[26];

}

class Contact{
	String name;
	int phone;
	public Contact(String name, int phone) {
		this.name = name;
		this.phone = phone;
	}

}