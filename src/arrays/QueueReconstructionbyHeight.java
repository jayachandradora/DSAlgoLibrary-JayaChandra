package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight {

	public static void main(String[] args) {

		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		reconstructQueue(people);
		disp();
	}

	static int[][] reconstructQueue(int[][] people) {
		
		//Sort based on height of people. here condition is if height is same then sort by kth index.
        Arrays.sort(people, (a, b) -> a[0] == b[0]? a[1] - b[1] : b[0]-a[0]);
		//[[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]
		
		List<int []> res = new ArrayList<>();
		for(int d[] : people)
			res.add(d[1],d);// ascending based on number of people
		
		
		int n = people.length;
		
		return res.toArray(new int[n][2]);
        //[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	}
	
	static void disp() {
		System.out.println("Hi");
	}

}
