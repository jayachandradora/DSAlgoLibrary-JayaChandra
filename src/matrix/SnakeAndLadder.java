package matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=19tY6Y90TP0
public class SnakeAndLadder {

	static class CellNode {
		int vertex; // Vertex number
		int distance; // distance of this vertex from source
	}
	
	static int MinimumDiceThrows(int board[], int N) {

		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}

		Queue<CellNode> q = new LinkedList<CellNode>();

		visited[0] = true;
		CellNode s = new CellNode();
		s.distance = 0;
		s.vertex = 0;
		q.add(s);

		CellNode qe = new CellNode();

		while (!q.isEmpty()) {
			
			qe = q.peek();
			int vertex = qe.vertex;

			if (vertex == N - 1){
				break;
			}
				
			q.remove();
			for (int i = vertex + 1; i <= (vertex + 6) && i < N; ++i) {

				if (visited[i] == false) {

					CellNode cell = new CellNode();
					cell.distance = (qe.distance + 1);
					visited[i] = true;
					if (board[i] != -1){
						
						cell.vertex = board[i];
					
					}else{
						
						cell.vertex = i;
					
					}
					q.add(cell);
					
				}
			}
		}

		return qe.distance;
	}
	
	public static void main(String[] args) {

		int N = 30; // Number of cells
		int board[] = new int[N];
		Arrays.fill(board, -1);

		// ladder
		board[2] = 21;
		board[4] = 7;
		board[10] = 25;
		board[19] = 28;

		// Snake
		board[26] = 0;
		board[20] = 8;
		board[16] = 3;
		board[18] = 6;
		
		System.out.println("Minimum number of controlled dice throws are " + MinimumDiceThrows( board, N));
	}
	
	
	
}
