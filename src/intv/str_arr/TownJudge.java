package intv.str_arr;

import java.util.HashMap;
import java.util.HashSet;

public class TownJudge {

	public static void main(String[] args) {
		int N = 3;
		int[][] trust = { { 1, 3 }, { 2, 3 } };
		System.out.println(findJudge(N, trust));

	}

	public static int findJudge(int N, int[][] trust) {
		int[] count = new int[N + 1];
		for (int[] t : trust) {
			count[t[0]]--;
			count[t[1]]++;
		}
		for (int i = 1; i <= N; ++i) {
			if (count[i] == N - 1)
				return i;
		}
		return -1;
	}

	public int findJudge1(int N, int[][] trust) {

		if (trust.length == 0)
			return 1;

		HashSet<Integer> hs = new HashSet<>();
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < trust.length; i++) {
			hs.add(trust[i][0]);

			int key = trust[i][1];
			if (hm.containsKey(key)) {
				hm.put(key, hm.get(key) + 1);
			} else {
				hm.put(key, 1);
			}
		}

		for (Integer key : hm.keySet()) {
			if (hm.get(key) == N - 1 && hs.contains(key) == false)
				return key;
		}

		return -1;
	}
}
