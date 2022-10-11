package intv.str_arr;

public class SingleNumber111 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 1, 3, 2, 5 };
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			res = res ^ nums[i];
		}

		// notice that 6^5 = 3, 6^3 = 5
		int[] r = new int[2];
		// find the lowest bit of the result
		// let's say 6 (0110), -6 = 1010 0110 & 1010 = 0010
		int lowbit = res & -res;
		// since this bit from the result is 1, we can be sure that
		// a & lowbit and b & lowbit have different result
		for (int n : nums) {
			if ((n & lowbit) == 0)
				r[0] = r[0] ^ n;
			else
				r[1] ^= n;
		}
		System.out.println("numbers : " + r[0] + " , " + r[1]);

		System.out.println(getSum(5, 7));

		int sh = 5 << 5;

		System.out.println(sh);

		int n[] = { 2, 2, 3, 2 };
		System.out.println(singleNumber(n));
		
		System.out.println(xorOperation(3, 3));

	}

	static int xorOperation(int n, int start) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans ^= start + i * 2;
		}
		return ans;
	}

	static int getSum(int a, int b) {
		while (b != 0) {
			int carry = (a & b) << 1;
			a = a ^ b;
			b = carry;
		}
		return a;
	}

	static int singleNumber(int[] nums) {
		int one = 0;
		int two = 0;

		for (int value : nums) {
			one = (one ^ value) & ~two;
			two = (two ^ value) & ~one;
		}
		return one;
	}
}
