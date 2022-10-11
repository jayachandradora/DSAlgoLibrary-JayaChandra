package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph5 {
	List<List<Integer>> graph;
	boolean visited[];
	int nodes;

	Graph5(int nodes) {
		graph = new ArrayList<>();
		visited = new boolean[nodes];
		this.nodes = nodes;

		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
		}
	}

	public void addEdge(int a, int b) {
		graph.get(a).add(b);
	}

	public boolean ifSourceConnectedToDestination(int source, int destination) {

		dfs(source);

		return visited[destination];
	}

	public void dfs(int index) {
		Stack<Integer> stack = new Stack<>();

		stack.push(index);
		visited[index] = true;

		while (!stack.isEmpty()) {
			Integer nodeIndex = stack.pop();
			visited[nodeIndex] = true;

			List<Integer> neighboursList = graph.get(nodeIndex);

			for (Integer neighbour : neighboursList) {
				if (!visited[neighbour]) {
					stack.push(neighbour);
				}
			}
		}
	}

	public void dfsAnother(int start) {
		visited[start] = true;

		List<Integer> neighboursList = graph.get(start);

		for (Integer neighbour : neighboursList) {
			if (!visited[neighbour]) {
				dfsAnother(neighbour);
			}
		}
	}
}

public class SourceToDestinationDirectedGraph {

	public static void main(String[] args) {
		int nodes = 5;

		Graph5 a = new Graph5(nodes);

		a.addEdge(0, 1);
		a.addEdge(1, 2);
		a.addEdge(2, 0);
		a.addEdge(3, 2);
		a.addEdge(3, 0);
		a.addEdge(2, 4);

		System.out.println(a.ifSourceConnectedToDestination(0, 3));
		System.out.println(a.ifSourceConnectedToDestination(0, 2));
	}
}
