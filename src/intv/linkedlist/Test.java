package intv.linkedlist;

public class Test {

	ListNode root;

	public static void main(String[] args) {

		Test t = new Test();
		t.root = new ListNode(1);
		t.root.next = new ListNode(2);
		t.root.next.next = new ListNode(3);
		t.root.next.next.next = new ListNode(3);
		t.root.next.next.next.next = new ListNode(4);
		t.root.next.next.next.next.next = new ListNode(4);
		t.root.next.next.next.next.next.next = new ListNode(5);
		t.addFirst(0);
		t.addLast(6);
		ListNode temp = t.removeAllDuplicate();
		while(temp.next != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
			
		//t.deleteDuplicate();
		ListNode node = t.root;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public ListNode removeAllDuplicate() {
		if(root == null)
			return root;
		ListNode prev, dummy = new ListNode(-1);
		prev = dummy;
		dummy.next = root;
		
		while(root != null & root.next != null) {
			if(root.val == root.next.val) {
				while(root.next != null & root.val == root.next.val)
					root = root.next;
				
				root = root.next;
				prev.next = root;
			}else {
				root = root.next;
				prev = prev.next;
			}
		}
		
		return dummy.next;
	
	}
	public ListNode deleteDuplicate() {
		if (root == null)
			return root;

		ListNode node = root;
		while (node != null && node.next != null) {
			if (node.val == node.next.val)
				node.next = node.next.next;
			else
				node = node.next;
		}
		return root;
	}
	
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node != null){
            if(node.next != null){
                if(node.val == node.next.val)
                    node.next = node.next.next;
                else
                    node = node.next;
            }else
                return head;
        }
        
        return head;
    }

	// 1->2->null
	public void addLast(int val) {
		if (root == null)
			root = new ListNode(val);

		ListNode node = root;
		while (node != null & node.next != null)
			node = node.next;

		node.next = new ListNode(val);
	}

	public void addFirst(int val) {
		ListNode node = new ListNode(val);
		node.next = root;
		root = node;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}