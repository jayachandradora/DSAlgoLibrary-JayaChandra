package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Edge {
	public final int source, dest;

	private Edge(int source, int dest) {
		this.source = source;
		this.dest = dest;
	}

	public static Edge of(int a, int b) {
		return new Edge(a, b); 
	}
}

class Graph7 {
	List<List<Integer>> adjList = null;

	Graph7(List<Edge> edges, int N) {
		adjList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the undirected graph
		for (Edge edge : edges) {
			adjList.get(edge.source).add(edge.dest);
		}
	}
}

public class PathBetweenVertices {
	public static boolean isConnected(Graph7 graph, int src, int dest, boolean[] visited, Stack<Integer> path) {
		visited[src] = true;

		path.add(src);	// include current node in the path

		if (src == dest) { // include current node in the path
			return true;
		}

		for (int i : graph.adjList.get(src)) {	// do for every edge (src -> i)
			if (!visited[i]) {  // u is not discovered
				if (isConnected(graph, i, dest, visited, path)) {	// return true if destination is found
					return true;
				}
			}
		}

		path.pop(); // backtrack: remove current node from the path

		return false; // return false if destination vertex is not reachable from src
	}

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(Edge.of(0, 3), Edge.of(1, 0), 
										 Edge.of(1, 2), Edge.of(1, 4), 
										 Edge.of(2, 7), Edge.of(3, 4), 
										 Edge.of(3, 5), Edge.of(4, 3), 
										 Edge.of(4, 6), Edge.of(5, 6), Edge.of(6, 7));
		int N = 8;
		Graph7 graph = new Graph7(edges, N);
		boolean[] discovered = new boolean[N];
		int src = 0, dest = 7;
		// To store the complete path between source and destination
		Stack<Integer> path = new Stack<>();

		if (isConnected(graph, src, dest, discovered, path)) {
			System.out.println("Path exists from vertex " + src + " to vertex " + dest);
			System.out.println("The complete path is: " + path);
		} else {
			System.out.println("No path exists between vertices " + src + " and " + dest);
		}
	}
}