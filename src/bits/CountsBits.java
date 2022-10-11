package bits;

public class CountsBits {

	public static void main(String[] args) {

		for (int num : countBits(5))
			System.out.print(num + " ");
	}

	static int[] countBits(int num) {

		int[] result = new int[num + 1];
		int p1 = 0;
		int p2 = 1;
		for (int i = 1; i <= num; i++) {
			result[i] = 1 + result[p1++];
			if (p1 == p2) {
				p1 = 0;
				p2 = i + 1;
			}
		}
		return result;
	}
}
