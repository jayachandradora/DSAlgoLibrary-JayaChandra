package arrays;

public class AllDuplicateAndMissingNumbers {

	static void duplicatesAndMissingNumbers(int arr[]) {

		int i = 0;
		int size = arr.length;
		while (i < size) {
			if (arr[i] != arr[arr[i] - 1]) {
				int temp = arr[i];
				arr[i] = arr[arr[i - 1]];
				arr[arr[i] - 1] = temp;
			} else {
				i++;
			}
		}

		for (i = 0; i < size; i++) {
			if (arr[i] != i + 1) {
				System.out.println("missing Number " + i + 1);
				System.out.println("Duplicate number " + arr[i]);
			}

		}
	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 5, 2 };

		duplicatesAndMissingNumbers(arr);
	}

}
