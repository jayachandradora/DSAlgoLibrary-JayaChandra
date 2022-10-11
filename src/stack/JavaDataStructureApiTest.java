package stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.PriorityBlockingQueue;

public class JavaDataStructureApiTest {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };

		linkedList(arr);
		stackOps(arr);
		queueOps(arr);
		priorityQueueOps(arr);
		hashMapOps(arr);
		
		int arr1[] = {10, 34, 5, 10, 3, 5, 10}; 
		treeOps(arr1);
	}

	static List<Integer> linkedList(int arr[]) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int in : arr)
			list.add(in);

		String str[] = { "ABC", "DEF", "GHI", "JKL" };
		LinkedList<String> strList = new LinkedList<String>();
		strList.addAll(Arrays.asList(str));
		strList.addFirst("jaya");

		System.out.println("string list " + strList);

		// list.addAll(Arrays.asList(arr)); // this ops is not allowing
		list.addFirst(0);
		list.addLast(11);
		list.remove();
		list.add(3, 2);
		list.remove(3);// remove based on index

		System.out.println("ArrayList " + list);

		return list;
	}

	static void stackOps(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		for (int in : arr)
			st.push(in);
		System.out.println(st);
		st.add(2, 10);
		System.out.println(st);
		st.remove(2);
		st.pop();

		System.out.println(st);

		st.clear();
		System.out.println("Empty stack st" + st);

		Stack st1 = new Stack();
		st1.add(1);
		st1.add("Jaya");
		st1.push(3.7);
		st1.size();
		st1.retainAll(Arrays.asList(arr));
		st1.addAll(Arrays.asList(arr));
		System.out.println("Stack1 " + st1);

	}

	static void queueOps(int arr[]) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(22);
		queue.add(33);
		queue.offer(44);
		queue.poll();
		queue.size();
		queue.retainAll(Arrays.asList(33));
		System.out.println(queue);
		for (int in : arr)
			queue.offer(in);

		System.out.println(queue);

		Iterator<Integer> it = queue.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");

		queue.clear();

	}

	static void priorityQueueOps(int arr[]) {
		Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int in : arr)
			queue.add(in);
		queue.add(5);
		System.out.println("Priority Queue " + queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);

		// As like PriorityQueue and only added flavor thread-safe.
		Queue<Integer> pbq = new PriorityBlockingQueue<Integer>();
		pbq.add(10);
		pbq.add(20);
		pbq.add(15);
		System.out.println(pbq.peek());

	}

	static void treeOps(int arr[]) {

		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			Integer c = tmap.get(arr[i]);

			if (tmap.get(arr[i]) == null)
				tmap.put(arr[i], 1);
			else
				tmap.put(arr[i], ++c);
		}

		// Print result
		for (Map.Entry m : tmap.entrySet())
			System.out.println("Frequency of " + m.getKey() + " is " + m.getValue());
	}

	static void hashMapOps(int arr[]) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(1, 10);
		hm.put(2, 20);
		hm.put(3, 30);
		hm.put(4, 40);
		hm.put(5, 50);

		Map<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
		hm1.put(6, 60);
		hm1.put(7, 70);
		hm1.put(8, 80);

		hm.putAll(hm1);

		for (Map.Entry<Integer, Integer> map : hm.entrySet())
			System.out.println("Key " + map.getKey() + " value " + map.getValue());

		System.out.println(hm.get(3));
		System.out.println(hm.getOrDefault(9, 9));

		for (Integer in : hm.keySet())
			System.out.print(in + " ");

		for (Integer in : hm.values())
			System.out.print(in + " ");

		System.out.println("Contains Key " + hm.containsKey(4));
		System.out.println("Contains Value " + hm.containsValue(30));
		System.out.println("Get value of map " + hm.get(3));

		Iterator<Map.Entry<Integer, Integer>> itr = hm.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, Integer> entry = itr.next();
			System.out.println("Key " + entry.getKey() + " value " + entry.getValue());
		}

		hm.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

	}
}
