package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class pair {
	int a = 0;
	int b = 0;

	pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class Test {
	
	static {
		System.out.println("Inside static block");
	}

	static List<Integer> colsestKNumbers(int arr[], int k, int x) {
		List<Integer> list = new ArrayList<>();
		Queue<pair> queue = new PriorityQueue<pair>((p1, p2)-> p1.a - p2.a);
		int counter = 0;
		for (int a : arr) {
			pair pa = new pair(Math.abs(a -x), a);
			queue.add(pa);
		}

		while (counter < 3) {
			pair in = queue.poll();
			list.add(in.a);
			System.out.print(in.b + " ");
			counter++;
		}
		return list;
	}

	public static void main(String[] args) {

		String words[] = { "i", "love", "leetcode", "i", "love", "coding" };
		// System.out.println(topKFrequent(words, 2));

		int arr[] = { 100, 200, 300, 50, 20, 1000, 2000, 3000 };
		// System.out.println(kthHeighstSalary(arr, 2));
		colsestKNumbers(arr, 3, 50);
		String str = "JayaChandra";
		String str1 = "JayaCchandra";
		char ch[] = str.toCharArray();
		str.charAt(0);
		String revStr = "abcabca";

		for (int i = 0; i < revStr.length() / 2; i++) {
			if (revStr.charAt(i) != revStr.charAt(revStr.length() - 1 - i)) {
				System.out.println(false);
			}

		}
		System.out.println(revStr.replaceAll(String.valueOf('c'), "j"));
		System.out.println(true);
		// System.out.println(str.contains(str1.subSequence(4, 11)));

		String word = " This	is  not   properly formatted		line ".trim();
		String c[] = word.split(" +");
		for (String st : c)
			System.out.print(st.trim());
		System.out.println(word.split("\\s+").length);

		Queue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(1);
		pq.add(3);
		pq.add(2);
		pq.add(9);
		pq.add(5);
		pq.add(3);

		System.out.println("-------------------------------------");

		StringBuilder sb = new StringBuilder("JayaChandra");
		System.out.println(sb.reverse().toString());

	}

	static int kthHeighstSalary(int arr[], int k) {

		Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));
		for (Integer in : arr)
			pq.add(in);

		int salary = 0;
		while (k > 0) {
			salary = pq.poll();
			k--;
		}

		return salary;
	}

	static List<String> topKFrequent(String[] words, int k) {
		if (words == null || k == 0 || k > words.length) {
			return null;
		}
		List<String> ans = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (String i : words) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (map.get(o2) != map.get(o1)) {
					return map.get(o2) - map.get(o1);
				}
				return o1.compareTo(o2);
			}
		});

		Queue<Map.Entry<String, Integer>> pq1 = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

		pq1.addAll(map.entrySet());
		while (k > 0) {
			ans.add(pq1.poll().getKey());
			k--;
		}

		/*
		 * for (String i : map.keySet()) { pq.add(i); } for (int i = 0; i < k; i++) {
		 * ans.add(pq.poll()); }
		 */
		return ans;
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);

		Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

		// for(Map.Entry<Integer,Integer> keySet : map.entrySet())
		// pq.offer(keySet);

		pq.addAll(map.entrySet());

		List<Integer> res = new ArrayList<>();

		while (k > 0) {
			res.add(pq.poll().getKey());
			k--;
		}

		return res;
	}
}
