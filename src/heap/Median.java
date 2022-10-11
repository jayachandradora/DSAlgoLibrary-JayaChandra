package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median {

	public static void main(String[] args) {

		Median obj = new Median();
		obj.addNum(1);
		obj.addNum(3);
		obj.addNum(2);
		double param_2 = obj.findMedian();
		System.out.println(param_2);
	}

	private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> large = new PriorityQueue<>();
	private boolean even = true;

	public double findMedian() {
		if (even)
			return (small.peek() + large.peek()) / 2.0;
		else
			return small.peek();
	}

	public void addNum(int num) {
		if (even) {
			large.offer(num);
			small.offer(large.poll());
		} else {
			small.offer(num);
			large.offer(small.poll());
		}
		even = !even;
	}

}