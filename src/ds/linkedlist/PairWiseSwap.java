package ds.linkedlist;

import ds.linkedlist.ReverseLinkedList.ListNode;

public class PairWiseSwap {

	static ListNode head;
	public static void main(String[] args) {

		PairWiseSwap list = new PairWiseSwap();
		list.head = new ListNode(85);
		list.head.next = new ListNode(15);
		list.head.next.next = new ListNode(4);
		list.head.next.next.next = new ListNode(20);
		list.head.next.next.next.next = new ListNode(30);
		list.head.next.next.next.next.next = new ListNode(35);
		
		pairWiseSwap(head);
		while(head != null) {
			System.out.println(head.data + " ");
			head = head.next;
		}
		
	}
	
	static void pairWiseSwap(ListNode head) {
		if(head != null && head.next != null) {
			swap(head);
			pairWiseSwap(head.next.next);
		}
		
	}
	
	static void swap(ListNode head) {
		ListNode temp = head; 
            /* Swap the data */
            int k = temp.data; 
            temp.data = temp.next.data; 
            temp.next.data = k; 
	}

}
