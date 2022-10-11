package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		

		int arr[] = { 3, 30, 34, 5, 9};
		System.out.println(largestNumber(arr));
	}

	static String largestNumber(int[] nums) {
		String[] strArr = new String[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			strArr[i] = Integer.toString(nums[i]);
		}
		
		Arrays.sort(strArr, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});
		
		//Arrays.sort(strArr, (a, b) -> (b + a).compareTo(b + a) );
		
		StringBuilder sb = new StringBuilder();
		for (String s : strArr) {
			sb.append(s);
		}
		
		while (sb.charAt(0) == '0' && sb.length() > 1)
			sb.deleteCharAt(0);
		
		return sb.toString();
	}

}
