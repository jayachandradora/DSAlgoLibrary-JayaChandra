package designpattern;

import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(1234));
		System.out.println(integerToRoman(3241));
	}

	public static TreeMap<Integer, String> map = new TreeMap<>();
	static {
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
		map.put(4, "IV");
		map.put(9, "IX");
		map.put(40, "XL");
		map.put(90, "XC");
		map.put(400, "CD");
		map.put(900, "CM");
	}

	public static String intToRoman(int num) {
		StringBuilder ans = new StringBuilder();
		while (num != 0) {
			Map.Entry<Integer, String> entry = map.floorEntry(num);
			ans.append(entry.getValue());
			num -= entry.getKey();
		}
		return ans.toString();
	}

	static String integerToRoman(int num) {

		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			if (num >= 1000) {
				sb.append("M");
				num -= 1000;
			} else if (num >= 900) {
				sb.append("C");
				sb.append("M");
				num -= 900;
			} else if (num >= 500) {
				sb.append("D");
				num -= 500;
			} else if (num >= 400) {
				sb.append("C");
				sb.append("D");
				num -= 400;
			} else if (num >= 100) {
				sb.append("C");
				num -= 100;
			} else if (num >= 90) {
				sb.append("X");
				sb.append("C");
				num -= 90;
			} else if (num >= 50) {
				sb.append("L");
				num -= 50;
			} else if (num >= 40) {
				sb.append("X");
				sb.append("L");
				num -= 40;
			} else if (num >= 10) {
				sb.append("X");
				num -= 10;
			} else if (num >= 9) {
				sb.append("I");
				sb.append("X");
				num -= 9;
			} else if (num >= 5) {
				sb.append("V");
				num -= 5;
			} else if (num >= 4) {
				sb.append("I");
				sb.append("V");
				num -= 4;
			} else if (num >= 1) {
				sb.append("I");
				num -= 1;
			}
		}
		return sb.toString();
	}
}
