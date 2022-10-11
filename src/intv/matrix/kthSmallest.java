package intv.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthSmallest {

	public static void main(String[] args) {
		int matrix[][] = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, k = 8;
		System.out.println(kthSmallest(matrix, k));
	}

	public static int kthSmallest(int[][] matrix, int k) {

		int N = matrix.length;

		PriorityQueue<MyHeapNode> minHeap = new PriorityQueue<MyHeapNode>(Math.min(N, k), new MyHeapComparator());

		for (int r = 0; r < Math.min(N, k); r++) // Preparing our min-heap
			minHeap.offer(new MyHeapNode(matrix[r][0], r, 0)); // We add triplets of information for each cell

		MyHeapNode element = minHeap.peek();
		
		while (k-- > 0) {

			element = minHeap.poll(); // Extract-Min
			int r = element.getRow(), c = element.getColumn();

			// If we have any new elements in the current row, add them
			if (c < N - 1) 
				minHeap.offer(new MyHeapNode(matrix[r][c + 1], r, c + 1));
			
		}

		return element.getValue();
	}

	public static int kthSmallest1(int[][] mx, int k) {

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> mx[a[0]][a[1]] - mx[b[0]][b[1]]);

		for (int i = 0; i < mx.length; i++) {
			pq.offer(new int[] { i, 0 });
		}

		while (k > 0) {

			int[] curr = pq.poll();
			k--;

			if (k == 0)
				return mx[curr[0]][curr[1]];

			if (curr[1] + 1 < mx[0].length)
				pq.offer(new int[] { curr[0], curr[1] + 1 });

		}
		return -1;
	}
}

class MyHeapComparator implements Comparator<MyHeapNode> {
	public int compare(MyHeapNode x, MyHeapNode y) {
		return x.value - y.value;
	}
}

class MyHeapNode {

	int row;
	int column;
	int value;

	public MyHeapNode(int v, int r, int c) {
		this.value = v;
		this.row = r;
		this.column = c;
	}

	public int getValue() {
		return this.value;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}
}