package ds.linkedlist;

public class RemoveDuplicatesSortedList {

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(5);


		print(removeAllDuplicates(head));
	}

	static Node removeDuplicates(Node head) {
		Node node = head;
		while (node != null) {
			if (node.next != null) {
				if (node.next.item == node.item)
					node.next = node.next.next;
				else
					node = node.next;
			} else
				return head;
		}
		return head;
	}

	// 1,1,3,4,4,2 Output = 3,2
	static Node removeAllDuplicates(Node head) {
		Node p, newNode = new Node(0);
		p = newNode;
		newNode.next = head;

		while (head != null && head.next !=null) {
			if(head.item == head.next.item) {
				while(head.next!= null && head.item == head.next.item)
					head = head.next;
				head =head.next;
				p.next = head;
			}else {
				head = head.next;
				p = p.next;
			}
		}
		return newNode.next;
	}

	static void print(Node head) {
		while (head != null) {
			System.out.print(" " + head.item);
			head = head.next;
		}
	}
}
