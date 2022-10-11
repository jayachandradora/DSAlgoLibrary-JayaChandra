package ds.linkedlist;

import ds.linkedlist.ReverseLinkedList.ListNode;

public class IntersectionNode {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(4);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(8);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(1);
		l2.next.next.next = new ListNode(8);
		l2.next.next.next.next = new ListNode(4);
		l2.next.next.next.next.next = new ListNode(5);

		System.out.println(getIntersectionNode(l1, l2).data);
	}

	static  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA, p2 = headB;
		while (p1 != p2) {
			if (p1 == null) {
				p1 = headB; // switch to headB
			} else {
				p1 = p1.next;
			}
			if (p2 == null) {
				p2 = headA; // switch to headA
			} else {
				p2 = p2.next;
			}
		}
		return p1;
	}
}
