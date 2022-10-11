package ds.linkedlist;

import java.util.List;
import java.util.PriorityQueue;

public class LinkedListDemo {

	Node head;

	public static void main(String[] args) {

		LinkedListDemo ls = new LinkedListDemo();
		ls.head = new Node(2);
		ls.head.next = new Node(5);
		ls.print(ls.head);

		System.out.println();

		ls.insertFirst(1);
		ls.print(ls.head);

		System.out.println();
		ls.insertAfter(2, 3);
		ls.print(ls.head);
		
		System.out.println();
		ls.deleteNode(ls.head, 2);
		ls.print(ls.head);
		
		Node ls1 = new Node(2);
		ls1.next = new Node(4);
		ls1.next.next = new Node(5);
		ls1.next.next.next = new Node(7);
		
		System.out.println();
		//Node ws = new Node(0);
		//ls.merge(ws, ls.head, ls1);
		
		//ls.print(ws.next);
		
		Node list[] = new Node[2];
				list[0] = ls.head;
				list[1] = ls1;
		System.out.println();
		ls.print(mergeKSortedArray(list));
	}

	void insertAfter(int val, int newVal) {
		Node node = head;
		while (node != null) {
			if (node.item == val) {
				Node next = node.next;
				Node temp = new Node(newVal);
				temp.next = next;
				node.next = temp;
			}
			node = node.next;
		}
	}
	
	void deleteNode(Node root, int val) {
		
		if(root == null)
			return;
		
		Node node = root;
		Node prev = null;
		if(node.item == val) {
			head = node.next;
			return;
		}
		prev = root;
		while(node != null) {
			if(node.item == val) {
				prev.next = node.next;
				node = prev;
			}
			prev = node;
			node = node.next;
		}
	}

	void insertFirst(int val) {

		Node temp = new Node(val);
		temp.next = head;
		head = temp;

	}
	
	public void merge(Node ws, Node l1,Node l2){
        while(l1 != null || l2 != null){
            if(l1 == null){
                ws.next = l2;
                l2 = l2.next;
            }else if(l2==null){
                ws.next = l1;
                l1=l1.next;
            }else if(l1.item < l2.item){
                ws.next = l1;
                l1=l1.next;
            }else{
                ws.next = l2;
                l2=l2.next;
            }
            ws = ws.next;
        }
    }
	
	static Node mergeKSortedArray(Node  []list) {
		if(list.length == 0)
			return null;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((l1, l2) -> l1.item - l2.item);
		for(Node node : list)
			pq.add(node);
		
		Node root = new Node(0);
		Node newNode = root;
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			if(temp.next != null) {
				pq.add(temp.next);
				newNode.next = temp;
				newNode = newNode.next;
			}
		}
		return root.next;
	}
	void print(Node head) {
		while (head != null) {
			System.out.print(" " + head.item);
			head = head.next;
		}
	}
}

class Node {

	int item;
	Node next;

	Node(int data) {
		item = data;
		next = null;
	}
}