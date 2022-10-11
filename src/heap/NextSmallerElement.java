package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NextSmallerElement {

	public static List<Integer> countSmaller(int[] arr) {
		Stack<Integer> s = new Stack<Integer>();
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		int n = arr.length - 1;

		s.push(arr[0]);

		for (int i = 1; i < n; i++) {

			if (s.empty()) {
				s.push(arr[i]);
				continue;
			}

			while (s.empty() == false && s.peek() > arr[i]) {
				mp.put(s.peek(), arr[i]);
				s.pop();
			}

			s.push(arr[i]);
		}
		while (s.empty() == false) {
			mp.put(s.peek(), -1);
			s.pop();
		}
		List ls = new ArrayList();
		for (int i = 0; i < n; i++)
			ls.add(mp.get(arr[i]));

		return ls;

	}

	public static void main(String[] args) {

		int arr[] = { 11, 13, 21, 3 };
		System.out.println(NextSmallerElement.countSmaller(arr));
	}

}
