package intv;

import java.util.HashSet;
import java.util.Set;

//Smarsh interview
public class SmarshIndiaInteverview {

	public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dog";

		if (isPanagram(str) == true)
			System.out.print(str + " is a pangram.");
		else
			System.out.print(str + " is not a pangram.");

		System.out.println(findMaxLenEven("this is a test string"));

		ListNode start = new ListNode(10);
		start.next = new ListNode(12);
		start.next.next = new ListNode(11);
		start.next.next.next = new ListNode(11);
		start.next.next.next.next = new ListNode(12);
		start.next.next.next.next.next = new ListNode(11);
		start.next.next.next.next.next.next = new ListNode(10);
		removeDuplicate(start);

		System.out.println(start.val);
		int arr1[] = { 1, 3, 4, 5 }, arr2[] = { 2, 4, 6, 8 };
		for (int in : merge2SortedArrays(arr1, arr2)) {
			System.out.print(in + " ");
		}
	}

	// arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
	static int[] merge2SortedArrays(int arr1[], int arr2[]) {
		int result[] = new int[arr1.length + arr2.length];

		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				result[k] = arr1[i];
				i++;
				k++;
			} else {
				result[k] = arr2[j];
				j++;
				k++;
			}
		}

		while (i < arr1.length) {
			result[k] = arr1[i];
			i++;
			k++;
		}

		while (j < arr2.length) {
			result[k] = arr2[j];
			j++;
			k++;
		}
		return result;
	}

	static boolean isPanagram(String str) {

		boolean isPanagram[] = new boolean[26];
		for (char ch : str.toCharArray()) {
			if (Character.isLetter(ch))
				isPanagram[Character.toLowerCase(ch) - 'a'] = true;
			else
				continue;
		}

		for (int i = 0; i <= 25; i++) {
			if (isPanagram[i] == false)
				return false;
		}
		return true;
	}

	// https://www.geeksforgeeks.org/find-the-first-maximum-length-even-word-from-a-string/
	static String findMaxLenEven(String str) {

		int maxlen = 0;
		StringBuilder strb = new StringBuilder();
		String maxlenString = null;
		for (char ch : str.toCharArray()) {
			if (Character.isLetter(ch))
				strb.append(ch);
			else {
				if (strb.length() % 2 == 0 && maxlen < strb.length()) {
					maxlen = strb.length();
					maxlenString = strb.toString();
				}
				strb = new StringBuilder();
			}
		}

		return strb.length() > maxlen ? strb.toString() : maxlenString;
	}

	static void removeDuplicate(ListNode head) {
		Set<Integer> set = new HashSet<>();

		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			if (set.contains(curr.val)) {
				prev.next = curr.next;
			} else {
				set.add(curr.val);
				prev = curr;
			}
			curr = curr.next;
		}
	}
}
