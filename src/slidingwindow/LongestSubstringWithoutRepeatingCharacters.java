package slidingwindow;

import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=4i6-9IzQHwo // kind of same solution video // best solution jd// sliding window approach
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int max = 0, j = 0, i = 0;
		
		while (j < n && i < n) {
			
			if (!set.contains(s.charAt(i))) {
				set.add(s.charAt(i++));
				max = Math.max(max, i - j);
			} else {
				set.remove(s.charAt(j++));
			}
		}
		
		return max;
	}

}
