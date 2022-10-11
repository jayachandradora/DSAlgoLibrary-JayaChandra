package intv.str_arr;

import java.util.HashMap;
import java.util.Map;

public class SubarrayKSum {

	public static void main(String[] args) {
		SubarrayKSum sks = new SubarrayKSum();
		int nums[] = { 10, 5, 7, 1, 2, 5, 3 };
		System.out.println(sks.subarraySum(nums, 15));
		System.out.println(sks.reverse(-8));
	}
	
	public int reverse(int number){
		
	    number = ~(number - 1) ;
	    return number;
	}


	public int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}

}
