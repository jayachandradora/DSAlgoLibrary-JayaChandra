package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestNumber {

	public static void main(String[] args) {
		int arr[] = { 1,2,3,4,5}, x = 3, k = 4;

		Queue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return b - x != x - a ? Math.abs(a - x) - Math.abs(b - x) : a - b;
			}
		});

		for (int i : arr)
			minHeap.add(i);
		
		List<Integer> res = new ArrayList<>();
		for(int i =0; i<k; i++)
			res.add(minHeap.poll());
		
		/*List<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++)
			res.add(minHeap.poll());

		Collections.sort(res);*/
		System.out.println(res);

	}
}
