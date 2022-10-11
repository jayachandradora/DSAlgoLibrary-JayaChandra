package ds.linkedlist;

import ds.linkedlist.ReverseLinkedList.ListNode;

public class AddTwoNumber {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(9);
		
		ListNode l3 = addTwoNumbers(l1, l2);
		while(l3 != null) {
			System.out.print(l3.data + " ");
			l3 = l3.next;
		}
			
	}

	static ListNode addTwoNumbers(ListNode L1, ListNode L2) {
		ListNode dummy = new ListNode(0), current = dummy;
		int carry = 0;

		while (L1 != null || L2 != null || carry > 0) {
			int sum = carry;

			if (L1 != null) {
				sum += L1.data;
				L1 = L1.next;
			}
			if (L2 != null) {
				sum += L2.data;
				L2 = L2.next;
			}

			current.next = new ListNode(sum % 10);
			current = current.next;
			carry = sum / 10;
		}
		return dummy.next;
	}

}
