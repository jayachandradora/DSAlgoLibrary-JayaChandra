package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequent {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> count = new HashMap<>();
		for (int n : nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		// init heap 'the less frequent element first'
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

		// keep k top frequent elements in the heap
		for (int n : count.keySet()) {
			heap.add(n);
			if (heap.size() > k)
				heap.poll();
		}

		List<Integer> res = new ArrayList<>();

		while (k > 0) {
			res.add(heap.poll());
			k--;
		}

		return res;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 };
		int k = 2;

		for (Integer l : topKFrequent(nums, k)) {
			System.out.print(l + " ");
		}
		System.out.println();
		sortFrequency(nums);
	}
	
	public static void sortFrequency(int[] nums) {
		HashMap<Integer, Integer> count = new HashMap<>();
		for (int n : nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(count.entrySet());
		Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

		for (Map.Entry<Integer, Integer> set : list)
			System.out.println(set.getKey() + " - " + set.getValue());

	}

}
