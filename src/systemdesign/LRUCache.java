package systemdesign;

import java.util.HashMap;

//https://www.youtube.com/watch?v=akFRa58Svug
//https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
public class LRUCache {

	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}

		return -1;
	}
	
	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);

			} else {
				setHead(created);
			}

			map.put(key, created);
		}
	}
	
	public void remove(Node n) {
		if (n.pre != null) {
			n.pre.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}

	}

	public void setHead(Node n) {
		n.next = head;
		n.pre = null;

		if (head != null)
			head.pre = n;

		head = n;

		if (end == null)
			end = head;
	}

	public static void main(String arg[]) {

		LRUCache lruCache = new LRUCache(3);
		System.out.println("capacity " + lruCache.capacity);

		lruCache.put(1, 2);
		lruCache.put(3, 6);
		lruCache.put(5, 10);
		lruCache.put(5, 10);
		lruCache.put(3, 30);
		lruCache.put(7, 14);

		System.out.println("Cache Size " + lruCache.get(6));
		Node n = new Node(5, 10);
		lruCache.remove(n);
		System.out.println("Remove" + lruCache.get(5));
	}

	static class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
