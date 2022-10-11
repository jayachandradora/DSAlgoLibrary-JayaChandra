package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SongsPair {

	public static void main(String[] args) {

		int time[] = { 30, 20, 150, 100, 40 };
		System.out.println(numPairsDivisibleBy601(time));
		System.out.println(minSteps("leetcode", "practice"));
	}

	
	public static int minSteps1(String s, String t) {
	    int ans = 0;
	    int[] count = new int[26];

	    for (char c: s.toCharArray())
	        count[c - 'a']++;

	    for (char c: t.toCharArray())
	        count[c - 'a']--;

	    for (int i: count) {
	        if (i >= 0)
	            ans += i;
	    }
	    return ans;
	}
	public static int minSteps(String s, String t) {

		int count[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}

		int ans = 0;
		for (int i : count) {
			if (i >= 0)
				ans += i;
		}

		return ans;
	}

	static int numPairsDivisibleBy60(int[] time) {
		int remainders[] = new int[60];
		int count = 0;

		for (int t : time) {

			if (t % 60 == 0) // check if a%60==0 && b%60==0
				count += remainders[0];
			else // check if a%60+b%60==60
				count += remainders[60 - t % 60];

			remainders[t % 60]++; // remember to update the remainders

		}
		return count;
	}

	public static int numPairsDivisibleBy601(int[] time) {

		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int in : time) {
			if (in % 60 == 0)
				count += map.getOrDefault(0, 0);
			else
				count += map.getOrDefault(60 - in % 60, 0);

			map.put(in % 60, map.getOrDefault(in % 60, 0) + 1);
		}

		return count;
	}
}
