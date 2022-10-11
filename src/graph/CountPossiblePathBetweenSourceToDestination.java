package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class CountPossiblePathBetweenSourceToDestination {

	public static void main(String[] args) {
		CountPossiblePathBetweenSourceToDestination sd = new CountPossiblePathBetweenSourceToDestination();
		Graph g = sd.new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 4);

		int s = 0, d = 3;
		System.out.println(g.countPaths(s, d));
		
	}

	class Graph {

		private int V;
		private LinkedList<Integer> adj[];

		@SuppressWarnings("unchecked")
		Graph(int v) {
			this.V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i)
				adj[i] = new LinkedList<>();
		}

		void addEdge(int v, int w) {
			adj[v].add(w);
		}

		int countPathsUtil(int u, int d, int pathCount) {
			if (u == d) {
				pathCount++;
			} else {
				Iterator<Integer> i = adj[u].listIterator();
				while (i.hasNext()) {
					int n = i.next();
					pathCount = countPathsUtil(n, d, pathCount);
				}
			}
			return pathCount;
		}

		int countPaths(int s, int d) {
			int pathCount = 0;
			pathCount = countPathsUtil(s, d, pathCount);
			return pathCount;
		}
	}

}
