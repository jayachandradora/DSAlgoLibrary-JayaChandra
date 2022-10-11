package hashing;

// Java code for Union and Intersection of two
// Linked Lists
import java.util.HashMap;
import java.util.HashSet;

public class UnionAndIntersection {

	Node head; // head of list

	/* Linked list Node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Utility function to print list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Inserts a node at start of linked list */
	void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	public void append(int new_data) {
		if (this.head == null) {
			Node n = new Node(new_data);
			this.head = n;
			return;
		}
		Node n1 = this.head;
		Node n2 = new Node(new_data);
		while (n1.next != null) {
			n1 = n1.next;
		}

		n1.next = n2;
		n2.next = null;
	}

	/*
	 * A utilty function that returns true if data is present in linked list
	 * else return false
	 */
	boolean isPresent(Node head, int data) {
		Node t = head;
		while (t != null) {
			if (t.data == data)
				return true;
			t = t.next;
		}
		return false;
	}

	UnionAndIntersection getIntersection(Node head1, Node head2) {
		HashSet<Integer> hset = new HashSet<>();
		Node n1 = head1;
		Node n2 = head2;
		UnionAndIntersection result = new UnionAndIntersection();

		// loop stores all the elements of list1 in hset
		while (n1 != null) {
			if (hset.contains(n1.data)) {
				hset.add(n1.data);
			} else {
				hset.add(n1.data);
			}
			n1 = n1.next;
		}

		// For every element of list2 present in hset
		// loop inserts the element into the result
		while (n2 != null) {
			if (hset.contains(n2.data)) {
				result.push(n2.data);
			}
			n2 = n2.next;
		}
		return result;
	}

	UnionAndIntersection getUnion(Node head1, Node head2) {
		// HashMap that will store the
		// elements of the lists with their counts
		HashMap<Integer, Integer> hmap = new HashMap<>();
		Node n1 = head1;
		Node n2 = head2;
		UnionAndIntersection result = new UnionAndIntersection();

		// loop inserts the elements and the count of
		// that element of list1 into the hmap
		while (n1 != null) {
			if (hmap.containsKey(n1.data)) {
				int val = hmap.get(n1.data);
				hmap.put(n1.data, val + 1);
			} else {
				hmap.put(n1.data, 1);
			}
			n1 = n1.next;
		}

		// loop further adds the elements of list2 with
		// their counts into the hmap
		while (n2 != null) {
			if (hmap.containsKey(n2.data)) {
				int val = hmap.get(n2.data);
				hmap.put(n2.data, val + 1);
			} else {
				hmap.put(n2.data, 1);
			}
			n2 = n2.next;
		}

		// Eventually add all the elements
		// into the result that are present in the hmap
		for (int a : hmap.keySet()) {
			result.append(a);
		}
		return result;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		UnionAndIntersection llist1 = new UnionAndIntersection();
		UnionAndIntersection llist2 = new UnionAndIntersection();
		UnionAndIntersection union = new UnionAndIntersection();
		UnionAndIntersection intersection = new UnionAndIntersection();

		/* create a linked list 10->15->4->20 */
		llist1.push(20);
		llist1.push(4);
		llist1.push(15);
		llist1.push(10);

		/* create a linked list 8->4->2->10 */
		llist2.push(10);
		llist2.push(2);
		llist2.push(4);
		llist2.push(8);

		intersection = intersection.getIntersection(llist1.head, llist2.head);
		union = union.getUnion(llist1.head, llist2.head);

		System.out.println("First List is");
		llist1.printList();

		System.out.println("Second List is");
		llist2.printList();

		System.out.println("Intersection List is");
		intersection.printList();

		System.out.println("Union List is");
		union.printList();
	}
}
// This code is contributed by Kamal Rawal
