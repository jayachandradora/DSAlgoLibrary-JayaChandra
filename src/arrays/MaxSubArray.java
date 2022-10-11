package arrays;

public class MaxSubArray {

	public static void main(String[] args) {
		// int nums[] = {-2,1,-3,4,-1,2,1,-5,4};

		int nums[] = { 1, 2, 3, 4 };
		int max = Integer.MIN_VALUE;

		System.out.println(o2Solution(nums));
		System.out.println(productSubArray(nums));
	}
	
	//https://www.youtube.com/watch?v=IDeyPqApnX0&ab_channel=NareshGupta
	static int productSubArray(int []nums) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			int product = 1;
			for(int j=0; j<nums.length; j++) {
				product *= nums[j];
				max = Math.max(max, product);
			}
		}
			return max;
	}
	
	 public int maxSubArrayONSoln(int[] nums) {
	        
	        if(nums.length == 0)
	            return 0;
	        
	        int sum =0, max=nums[0];
	        
			for(int i =0; i<nums.length; i++) {
				sum = sum + nums[i];
				
	            if(sum > max)
				    max = sum;
				if(sum < 0)
					sum = 0;
	            
			}
	        
	        return max;
			
	    }
	
	static int o2Solution(int nums[]) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				max = Math.max(max, sum);
			}
		}

		return max;
	}

	static int o3Solution(int nums[]) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {

			for (int j = i; j < nums.length; j++) {

				int sum = 0;

				for (int k = i; k <= j; k++) {
					sum += nums[k];
					max = Math.max(max, sum);
				}
			}
		}

		return max;
	}
}
