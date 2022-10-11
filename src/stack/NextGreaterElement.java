package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int arr[] = { 4, 1, 5, 2, 25 };
		nextGreaterRight(arr, arr.length);

		int price[] = { 10, 4, 5, 90, 120, 80 };
		int n = price.length;
		int S[] = new int[n];

		calculateStockSpan(price, n, S);
		System.out.print("calculate Stock Span " + Arrays.toString(S));

		System.out.println("nearestGreatestLeft ");
		for (int i : nearestGreatestLeft(arr, arr.length))
			System.out.print(i + " ");
		
	}

	public static int[] nearestGreatestLeft(int arr[], int size) {
		Stack<Integer> st = new Stack<Integer>();
		int res[] = new int[size];
		res[0] = -1;
		st.push(arr[0]);
		for (int i = 1; i < size; i++) {
			if (st.size() == 0) {
				st.push(arr[i]);
			} else if (st.peek() > arr[i]) {
				res[i] = st.peek();
				st.push(arr[i]);
			} else {
				while (!st.isEmpty() && st.peek() <= arr[i])
					st.pop();
				if (st.isEmpty())
					res[i] = -1;
				else
					res[i] = st.peek();
				st.push(arr[i]);
			}
		}
		return res;
	}

	static void nextGreaterRight(int arr[], int size) {
		Stack<Integer> st = new Stack<Integer>();

		for (int i = size - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				st.add(arr[i]);
				System.out.println(arr[i] + " --> " + -1);
			} else if (st.peek() > arr[i]) {
				System.out.println(arr[i] + " --> " + st.peek());
				st.add(arr[i]);
			} else {
				while (!st.isEmpty() && st.peek() <= arr[i])
					st.pop();

				if (st.isEmpty())
					System.out.println(arr[i] + " --> " + -1);
				else
					System.out.println(arr[i] + " --> " + st.peek());
				st.add(arr[i]);
			}
		}
	}

	static void nextSmallerRight(int arr[], int size) {
		Stack<Integer> st = new Stack<Integer>();

		for (int i = size - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				st.add(arr[i]);
				System.out.println(arr[i] + " --> " + -1);
			} else if (st.peek() < arr[i]) {
				System.out.println(arr[i] + " --> " + st.peek());
			} else {
				while (!st.isEmpty() && st.peek() >= arr[i])
					st.pop();

				if (st.isEmpty())
					System.out.println(arr[i] + " --> " + -1);
				else
					System.out.println(arr[i] + " --> " + st.peek());
				st.add(arr[i]);
			}
		}
	}

	static void calculateStockSpan(int price[], int n, int S[]) {
		Stack<Integer> st = new Stack<>();
		st.push(0);
		S[0] = 1;

		for (int i = 1; i < n; i++) {

			while (!st.empty() && price[st.peek()] <= price[i])
				st.pop();

			if (st.empty())
				S[i] = i + 1;
			else
				S[i] = i - st.peek();

			st.push(i);
		}
	}

	
}
