package arrays;

public class MissingNumber {

	public static void main(String[] args) {
		
		int nums[] = {2,1,4};

		System.out.println(missingNumber(nums));
	}
	
	static int missingNumber(int[] nums) {
        int miss = 0, i = 0;
        
        for (int num : nums)
            miss += ++i - num;
        
        return miss;

    }

}
