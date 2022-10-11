package intv.str_arr;

//https://www.youtube.com/watch?v=3X9-qs1Lwe4
public class ProductExceptSelf {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4 };
		for (int in : productExceptSelf1(nums))
			System.out.print(in + " ");

	}

	static int[] productExceptSelf(int[] nums) {
		int[] ans = new int[nums.length];
		int N = ans.length;
		int left = 1;

		for (int i = 0; i < N; i++) {
			ans[i] = left;
			left *= nums[i];
		}

		int right = 1;
		for (int i = N - 1; i >= 0; i--) {
			ans[i] = ans[i] * right;
			right *= nums[i];
		}
		return ans;
	}

	public static int[] productExceptSelf1(int[] nums) {

		int leftProduct[] = new int[nums.length];
		int rightProduct[] = new int[nums.length];
		int[] answer = new int[nums.length];

		leftProduct[0] = 1;
		for (int i = 1; i < nums.length; i++)
			leftProduct[i] = leftProduct[i - 1] * nums[i - 1];

		rightProduct[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--)
			rightProduct[i] = rightProduct[i + 1] * nums[i + 1];

		for (int i = 0; i < nums.length; i++)
			answer[i] = leftProduct[i] * rightProduct[i];

		return answer;
	}
}
