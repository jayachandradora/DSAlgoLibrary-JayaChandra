package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {

	public static void main(String[] args) {

		int arr[] = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		System.out.println("kth lagest element : " + kthLargest(arr, k));

		int arr1[] = { 1, 2, 3, 4, 5 };
		int k1 = 4, x = 3;
		System.out.println(findClosestElements(arr1, k1, x));
		
		System.out.println("findClosestElementsJC");
		for(Integer in : findClosestElementsJC(arr1, k1, x))
			System.out.print(in + " ");
	}

	static int kthLargest(int arr[], int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);

			if (pq.size() > k)
				pq.poll();
		}
		return pq.peek();
	}

	static List<Integer> findClosestElementsJC(int[] arr, int k, int x) {
		Queue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.val - o2.val;
			}
		});
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++)
			pq.add(new Node(arr[i], Math.abs(arr[i]-x)));
		
		for(int i=0; i<k; i++)
			list.add(pq.poll().key);
		
		return list;
		
	}
	static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int a : arr) {
			int abs = Math.abs(a - x);

			if (!map.containsKey(abs))
				map.put(abs, new LinkedList<>());
			map.get(abs).add(a);
		}
		for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			for (int i : e.getValue()) {
				result.add(i);
				if (result.size() == k)
					break;
			}
			if (result.size() == k)
				break;
		}
		Collections.sort(result);
		return result;
	}

	static List<Integer> findClosestElements1(int[] arr, int k, int x) {
		int left = 0;
		int right = arr.length - k;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (x - arr[mid] > arr[mid + k] - x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int i = left; i < left + k; i++)
			res.add(arr[i]);
		return res;
	}
}

class Node{
	int key;
	int val;
	
	public Node(int key, int val) {
		this.key = key;
		this.val = val;
	}
	
}
