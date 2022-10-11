package ds.linkedlist;

public class Palindrome {

	static Node2 head;

	public static void main(String[] args) {

		Palindrome list = new Palindrome();
		list.head = new Node2("a");
		list.head.next = new Node2("bc");
		list.head.next.next = new Node2("d");
		list.head.next.next.next = new Node2("dcb");
		list.head.next.next.next.next = new Node2("a");
		System.out.println(ispalindrome(head));
	}

	static boolean ispalindrome(Node2 head) {
		StringBuilder str = new StringBuilder();
		while (head != null) {
			str.append(head.data);
			head = head.next;
		}
		String str2 = new String(str);
		return str.reverse().toString().equals(str2) ? true : false;
	}
	
	static void deleteList(Node2 head) 
	{ 
	    if (head == null) 
	        return; 
	    deleteList(head.next);  
	    System.gc(); 
	} 
}

class Node2 {
	String data;
	Node2 next;

	Node2(String d) {
		data = d;
		next = null;
	}
}