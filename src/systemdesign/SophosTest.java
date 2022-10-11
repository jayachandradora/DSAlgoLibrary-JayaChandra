package systemdesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SophosTest {

	/// Input: []
	// Output: [["edit", "diet"], ["now", "won", "own"]]
	// Integer roman to Number

	public static void main(String[] args) {
		System.out.println(intToRoman(1234));
		String strs[] = { "edit", "now", "won", "own", "diet", };
		System.out.println(groupOfAnagram(strs));
		
		mapTest();
		int arr[] = {1,2,4,2};
		Arrays.sort(arr);
		System.out.println(countGoodTriplets(4));
	}

	static List<List<String>> groupOfAnagram(String strs[]) {

		List<List<String>> list = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String str : strs) {
			char ch1[] = new char[26];
			for (char ch : str.toCharArray())
				ch1[ch - 'a']++;

			String strn = new String(ch1);
			if (map.containsKey(strn))
				map.get(strn).add(str);
			else {
				List<String> lst = new ArrayList<>();
				lst.add(str);
				map.put(strn, lst);
			}
		}
		list.addAll(map.values());
		return list;
	}

	static String intToRoman(int num) {
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
	
	static void mapTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("j", "jaya");
		map.put("i", "ishani");
		map.put("s", "Suman");
		List<String> list = new ArrayList<>();
		
		for(Map.Entry<String, String> entry : map.entrySet()) {
			list.add(entry.getKey());
			list.add(entry.getValue());
		}
		
		System.out.println("map.get(j) " + map.get("j"));
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		Map<String, String> map1 = new HashMap<String, String>();
		
		map1.putAll(map);
		System.out.println("Size " + map1.size());
		if(map.containsKey("i")) {
			map.remove("i");
		}
		
		map.clear();
		
		if(map.isEmpty())
			System.out.println(map.keySet());
	}
	
	static int[] countGoodTriplets(int n) {
		int arr[]=new int[n];
        int max=n/2;
        int j=0;
        
        if(n%2==0){
            for(int i=-max;i<=max;i++){
                if(i!=0)
                 arr[j++]=i;
            }
        } else {
            for(int i=-max;i<=max;i++){
                 arr[j++]=i;
            }
        }
        
        return arr;
    }
}
