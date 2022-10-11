package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://www.techiedelight.com/single-source-shortest-paths-dijkstras-algorithm/
//Time Complexity : O(E Log V)
public class ShortestPathDijkstras {

	public static void main(String[] args) {
		List<Edge8> edges = Arrays.asList(new Edge8(0, 1, 10), new Edge8(0, 4, 3), 
										  new Edge8(1, 2, 2), new Edge8(1, 4, 4), 
										  new Edge8(2, 3, 9), new Edge8(3, 2, 7), 
										  new Edge8(4, 1, 1), new Edge8(4, 2, 8),
										  new Edge8(4, 3, 2));
		final int N = 5;
		Graph8 graph = new Graph8(edges, N);
		int source = 0;
		shortestPath(graph, source, N);
	}

	private static void getRoute(int[] prev, int i, List<Integer> route) {
		if (i >= 0) {
			getRoute(prev, prev[i], route);
			route.add(i);
		}
	}

	// Run Dijkstra's algorithm on given graph
	public static void shortestPath(Graph8 graph, int source, int N) {
		// create min heap and push source node having distance 0
		PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
		minHeap.add(new Node(source, 0));

		List<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));
		dist.set(source, 0);

		// boolean array to track vertices for which minimum cost is already found
		boolean[] done = new boolean[N];
		done[source] = true;

		// stores predecessor of a vertex (to print path)
		int[] prev = new int[N];
		prev[source] = -1;

		List<Integer> route = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			Node node = minHeap.poll();
			// get vertex number
			int u = node.vertex;

			// do for each neighbor v of u
			for (Edge8 edge : graph.adjList.get(u)) {
				int v = edge.dest;
				int weight = edge.weight;

				// Relaxation step
				if (!done[v] && (dist.get(u) + weight) < dist.get(v)) {
					dist.set(v, dist.get(u) + weight);
					prev[v] = u;
					minHeap.add(new Node(v, dist.get(v)));
				}
			}

			// marked vertex u as done so it will not get picked up again
			done[u] = true;
		}

		for (int i = 1; i < N; ++i) {
			if (i != source && dist.get(i) != Integer.MAX_VALUE) {
				getRoute(prev, i, route);
				System.out.printf("Path (%d -> %d): Minimum Cost = %d and Route is %s", source, i, dist.get(i), route);
				route.clear();
			}
		}
	}
}

class Edge8 {
	int source, dest, weight;
	public Edge8(int source, int dest, int weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
}

class Node {
	int vertex, weight;
	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

class Graph8 {
	List<List<Edge8>> adjList = null;
	Graph8(List<Edge8> edges, int N) { //Create a Graph with vertices and edges
		adjList = new ArrayList<>();

		for (int i = 0; i < N; i++) {  // add all vertices
			adjList.add(new ArrayList<>());
		}

		for (Edge8 edge : edges) { //link all edges to vertices
			adjList.get(edge.source).add(edge);
		}
	}
}