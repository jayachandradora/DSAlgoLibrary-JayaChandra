package arrays;
//https://www.interviewbit.com/problems/repeat-and-missing-number-array/
public class MissingAndRepeatNumber {

	public static void main(String[] args) {

		int arr[] = { 3, 1, 2, 5, 3 };

		int check[] = new int[arr.length+1];
		int repeat = 0;
		int missing = 0;

		for (int i = 0; i < arr.length; i++) {
			if (check[arr[i]] == 0)
				check[i] = 1;
			else {
				repeat = arr[i];
				System.out.println("Repeat " + repeat);
			}
		}

		for (int j = 1; j < arr.length; j++)
			if (check[j] == 0)
				missing = j;

		System.out.println("Missing " + missing);
	}

}
