package arrays;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConsecutiveOnes1Flip {

	public static void main(String[] args) {
		int nums[] = { 1, 0, 1, 1, 0 };
		System.out.println(findMaxConsecutiveOnes(nums));
		System.out.println(findMaxConsecutiveOnes1(nums));

		 int A[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		//int A[] = { 1, 0, 1, 1, 1, 0, 1, 1, 0 };
		int K = 1;
		System.out.println(longestOnes(A, K));
		int num[] = {1,3,-1,-3,5,3,6,7}; int k= 3;
		maxSlidingWindow(num, k);
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, k = 1; // flip at most k zero
		Queue<Integer> zeroIndex = new LinkedList<>();
		for (int l = 0, h = 0; h < nums.length; h++) {
			if (nums[h] == 0)
				zeroIndex.offer(h);
			if (zeroIndex.size() > k)
				l = zeroIndex.poll() + 1;
			max = Math.max(max, h - l + 1);
		}
		return max;
	}

	// above one OR below one and o(1) space
	public static int findMaxConsecutiveOnes1(int[] nums) {
		int maxConsecutive = 0, zeroLeft = 0, zeroRight = 0;
		for (int i = 0; i < nums.length; i++) {
			zeroRight++;
			if (nums[i] == 0) {
				zeroLeft = zeroRight;
				zeroRight = 0;
			}
			maxConsecutive = Math.max(maxConsecutive, zeroLeft + zeroRight);
		}
		return maxConsecutive;
	}

	public static int longestOnes(int[] A, int K) {
		int i = 0, j;
		for (j = 0; j < A.length; ++j) {
			if (A[j] == 0)
				K--;
			if (K < 0 && A[i++] == 0)
				K++;
		}
		return j - i;
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length <= 1) {
			return nums;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		Queue<Integer> q = new ArrayDeque<Integer>();

		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < k; i++) {
			q.offer(nums[i]);
			pq.offer(nums[i]);
		}
		result[0] = pq.peek();
		for (int i = 1; i < result.length; i++) {
			Integer r = q.poll();
			pq.remove(r);
			q.offer(nums[i + k - 1]);
			pq.offer(nums[i + k - 1]);
			result[i] = pq.peek();
		}
		return result;
	}
}
