package intv.dp;

public class JumpGame {

	public static void main(String[] args) {

		int nums[] = { 3, 2, 1, 0, 4 };
		int reachable = 0;
		for (int i = 0; i < nums.length; i++) {
			if (reachable < i) {
				System.out.println(false);
				break;
			}
			reachable = Math.max(reachable, i + nums[i]);
		}

		System.out.println("true");
	}

}
