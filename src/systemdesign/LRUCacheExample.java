package systemdesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheExample {

	private Map<Integer, Node> map = new HashMap<>();
	private Node head;
	private Node last;
	private int capacity;

	public LRUCacheExample(final int capacity) {
		this.capacity = capacity;
		head = new Node(0, 0);
		last = new Node(0, 0);
		head.next = last;
		last.prev = head;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) 
			remove(map.get(key));
		
		if (map.size() == capacity) 
			remove(last.prev);
		
		insert(new Node(key, value));
	}
	
	public int get(int key) {
		Node node = map.get(key);
		
		if (node == null) 
			return -1;
		
		remove(node);
		insert(node);
		return node.value;
	}

	private void insert(Node node) {
		map.put(node.key, node);
		node.next = head.next;
		head.next.prev = node;
		node.prev = head;
		head.next = node;
	}

	private void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public static void main(String[] args) {
		LRUCacheExample lru = new LRUCacheExample(3);
		lru.put(1, 10);
		lru.put(2, 20);
		lru.put(3, 30);
		lru.put(3, 33);
		lru.get(1);
		System.out.println(lru.map);
	}

	class Node {
		int key;
		int value;
		Node prev;
		Node next;

		Node(int k, int v) {
			key = k;
			value = v;
		}
	}

}
