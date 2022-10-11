package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TRR {

	public static void main(String[] args) {

		

		String pattern = "abba", str = "dog cat cat dog";
		System.out.println(wordPattern1(pattern, str));

	}

	public static boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map map = new HashMap();
		for (Integer i = 0; i < pattern.length(); i++)
			if (map.put(words[i], i) != map.put(pattern.charAt(i), i))
				return false;
		return true;
	}

	public static boolean wordPattern1(String pattern, String str) {
		String[] words = str.split(" ");
		if (pattern.length() != words.length)
			return false;
		Map<String, Integer> wordToIndex = new HashMap<>();
		Map<Character, Integer> charToIndex = new HashMap<>();
		for (Integer i = 0; i < words.length; i++) {
			if (wordToIndex.put(words[i], i) != charToIndex.put(pattern.charAt(i), i))
				return false;
		}
		return true;
	}

}
