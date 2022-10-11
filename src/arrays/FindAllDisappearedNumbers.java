package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDisappearedNumbers {

	public static void main(String[] args) {

		int nums[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
		
		for (int i = 0; i < nums.length; i++) {
			int j = Math.abs(nums[i] )- 1;
			nums[j] = Math.abs(nums[j]) * -1;
		}

		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++)
			if (nums[i] > 0)
				res.add(i + 1);

		for (Integer in : res)
			System.out.print(in + " ");
	}

}
