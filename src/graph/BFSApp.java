package graph;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=K9ptqh2pU9M&list=PLt4nG7RVVk1geg-Y5VOa9dDM0kKKMFWZo&index=3
class Vertex1 {
	public char label;
	public boolean wasVisited;

	public Vertex1(char lab) {
		label = lab;
		wasVisited = false;
	}
}

class Graph1 {

	private final int MAX_VERTS = 20;
	private Vertex1 vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Queue<Integer> q;

	public Graph1() {
		vertexList = new Vertex1[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		q = new LinkedList<Integer>();
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex1(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++) {
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
				return j;
			}
		}
		return -1;
	}

	public void bfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		q.add(0);
		int v2;

		while (!q.isEmpty()) {
			int v1 = q.remove();
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				q.add(v2);
			}
		}
	}
}

public class BFSApp {

	public static void main(String[] args) {

		Graph1 theGraph = new Graph1();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');

		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(0, 3);
		theGraph.addEdge(3, 4);
		theGraph.addEdge(4, 5);
		theGraph.addEdge(1, 3);

		System.out.println("DFS Visits: ");
		theGraph.bfs();
		System.out.println();
	}

}
