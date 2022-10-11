package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {

	public static void main(String[] args) {

		System.out.println(frequencySortSoln("jaya"));
	}

	static String frequencySort(String s) {
		Map<Character, Integer> count = new HashMap<>();

		for (char c : s.toCharArray()) {
			count.put(c, count.getOrDefault(c, 0) + 1);
		}

		Queue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

		heap.addAll(count.entrySet());

		StringBuilder sb = new StringBuilder();
		while (!heap.isEmpty()) {
			Map.Entry<Character, Integer> entry = heap.poll();
			for (int i = 0; i < entry.getValue(); ++i) {
				sb.append(entry.getKey());
			}
		}
		return sb.toString();
	}

	static String frequencySortSoln(String s) {
		
		int n = s.length(), count[] = new int[256];
		
		for (int i = 0; i < n; i++)
			count[s.charAt(i)]++;
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((i, j) -> count[j] - count[i]);
		
		for (int i = 0; i < 256; i++) {
			if (count[i] == 0)
				continue;
			queue.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!queue.isEmpty()) {
			int i = queue.poll();
			while (count[i]-- > 0)
				sb.append((char) i);
		}
		return sb.toString();
	}

}
