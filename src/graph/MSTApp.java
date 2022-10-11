package graph;

import java.util.Stack;

class Vertex3 {
	public char label;
	public boolean wasVisited;

	public Vertex3(char lab) {
		label = lab;
		wasVisited = false;
	}
}

class Graph3 {

	private final int MAX_VERTS = 20;
	private Vertex3 vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Stack<Integer> s;

	public Graph3() {
		vertexList = new Vertex3[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		s = new Stack<Integer>();
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex3(lab);
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

	public void mst() {
		vertexList[0].wasVisited = true;
		s.push(0);

		while (!s.isEmpty()) {
			int current = s.peek();
			int v = getAdjUnvisitedVertex(current);

			if (v == -1) {
				s.pop();
			} else {
				vertexList[v].wasVisited = true;
				displayVertex(current);
				displayVertex(v);
				System.out.print(" ");
				s.push(v);
			}
		}
	}
}

public class MSTApp {

	public static void main(String[] args) {

		Graph3 a = new Graph3();
		a.addVertex('A');
		a.addVertex('B');
		a.addVertex('C');
		a.addVertex('D');
		a.addVertex('E');

		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(0, 3);
		a.addEdge(0, 4);
		a.addEdge(1, 2);
		a.addEdge(1, 3);
		a.addEdge(1, 4);
		a.addEdge(2, 3);
		a.addEdge(2, 4);
		a.addEdge(3, 4);

		System.out.println("MST: ");
		a.mst();
	}
}
