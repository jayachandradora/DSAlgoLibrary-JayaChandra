package intv.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class tt {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };

		for (List<Integer> list : new tt().subsets(4, 3))
			System.out.print(list + ", ");

		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int n = arr.length;
		int sum = 23;

		System.out.println(new tt().subArraySum(arr, n, sum));

		int arr1[] = { 1, 2, 3, 1, 3, 6, 6 };
		int arr_size = arr1.length;

		new tt().printRepeating(arr1, arr_size);
		
		int arr2[] = {10, 5, 3, 4, 3, 5, 6};
        printFirstRepeating(arr2);
	}

	static void printFirstRepeating(int arr[]) {

		int min = -1;
		HashSet<Integer> set = new HashSet<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (set.contains(arr[i]))
				min = i;
			else 
				set.add(arr[i]);
		}
		if (min != -1)
			System.out.println("The first repeating element is " + arr[min]);
		else
			System.out.println("There are no repeating elements");
	}

	void printRepeating(int arr[], int size) {
		int i;
		System.out.println("The repeating elements are : ");

		for (i = 0; i < size; i++) {
			int j = Math.abs(arr[i]);
			if (arr[j] >= 0)
				arr[j] = -arr[j];
			else
				System.out.print(j + " ");
		}
	}

	public List<List<Integer>> subsets(int num, int size) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();

		rec(num, 1, new ArrayList<>(), subsets, size);
		return subsets;
	}

	private void rec(int nums, int start, List<Integer> current, List<List<Integer>> subsets, int size) {
		if (0 == size)
			subsets.add(new ArrayList<>(current));

		for (int i = start; i <= nums; i++) {
			current.add(i);
			rec(nums, i + 1, current, subsets, size - i);
			current.remove(current.size() - 1);
		}
	}

	int subArraySum(int arr[], int n, int sum) {
		int cSum = arr[0], start = 0, i;

		for (i = 1; i <= n; i++) {
			while (cSum > sum && start < i - 1) {
				cSum = cSum - arr[start];
				start++;
			}

			if (cSum == sum) {
				int p = i - 1;
				System.out.println("Sum found between indexes " + start + " and " + p);
				return 1;
			}

			if (i < n)
				cSum = cSum + arr[i];

		}

		System.out.println("No subarray found");
		return 0;
	}
}
