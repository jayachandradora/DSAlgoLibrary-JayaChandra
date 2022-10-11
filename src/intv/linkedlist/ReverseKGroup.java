package intv.linkedlist;

//latest ...https://www.youtube.com/watch?v=jtVkMfCSH3I&ab_channel=CodingDecoded
public class ReverseKGroup {
	ListNode root;

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) 
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		int totalNodes = 0;
		ListNode curr = head;

		// counts the total no of nodes
		while (curr != null) {
			totalNodes++;
			curr = curr.next;
		}
		curr = head;
		ListNode next = null;
		ListNode prev = dummy;

		while (totalNodes >= k) {
			curr = prev.next;
			next = curr.next;

			for (int i = 1; i < k; i++) {// k-1 times
				curr.next = next.next;
				next.next = prev.next;
				prev.next = next;
				next = curr.next;
			}
			prev = curr;
			totalNodes = totalNodes - k;
		}
		return dummy.next;
	}

	public static void main(String[] args) {

		ReverseKGroup t = new ReverseKGroup();

		t.root = new ListNode(1);
		t.root.next = new ListNode(2);
		t.root.next.next = new ListNode(3);
		t.root.next.next.next = new ListNode(4);
		t.root.next.next.next.next = new ListNode(5);
		t.root.next.next.next.next.next = new ListNode(6);
		t.root.next.next.next.next.next.next = new ListNode(7);
		t.root.next.next.next.next.next.next.next = new ListNode(8);
		
		ListNode head = t.reverseKGroup(t.root, 5);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next; 
		}

	}

}
