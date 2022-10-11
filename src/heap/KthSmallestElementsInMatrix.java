package heap;

import java.util.PriorityQueue;

public class KthSmallestElementsInMatrix {

	public static void main(String[] args) {

		int mx[][] = {{ 1,  5,  9},
		                {10, 11, 13},
		                {12, 13, 15}};
		int k = 8;
		
		System.out.println(kthSmallest(mx, k));


	}
	
	static int kthSmallest(int[][] mx, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> mx[a[0]][a[1]] - mx[b[0]][b[1]]);
        for (int i = 0; i < mx.length; i++) {
            pq.offer(new int[] {i, 0});
        }
        while (k > 0) {
            int[] curr = pq.poll();
            k--;
            if (k == 0) return mx[curr[0]][curr[1]];
            if (curr[1] + 1 < mx[0].length) pq.offer(new int[] {curr[0], curr[1] + 1});
        }
        return -1;
 
    }

}
