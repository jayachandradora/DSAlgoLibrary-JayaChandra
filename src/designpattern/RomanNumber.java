package designpattern;

import java.util.HashMap;
import java.util.Map;

public class RomanNumber {

	public static void main(String[] args) {

		RomanNumber ob = new RomanNumber();
		String s = "MMMCMIV";
		System.out.println("Integer form of Roman Numeral  " + s + " is " + ob.romanDecimal(s));
		System.out.println("2nd Solution " + romanToInt(s));
	}

	int romanDecimal(String s) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int res = 0, curr = 0, prev = 0;

		for (int i = s.length() - 1; i >= 0; i--) {

			curr = map.get(s.charAt(i));
			if (curr >= prev)
				res = res + curr;
			else
				res = res - curr;

			prev = curr;
		}
		return res;
	}

	// 2nd solution
	static int romanToInt(String s) {
		Map<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("M", 1000);
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);

		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length()) {
				String key = s.charAt(i) + "" + s.charAt(i + 1);
				int result = map.getOrDefault(key, 0);
				if (result > 0) {
					sum += result;
					i++;
					continue;
				}
			}
			sum += map.getOrDefault("" + s.charAt(i), 0);
		}
		return sum;
	}
}
