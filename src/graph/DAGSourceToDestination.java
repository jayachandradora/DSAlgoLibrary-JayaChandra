package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DAGSourceToDestination {

	public static void main(String[] args) {
		int [][]graph = {{1,2},{3},{3},{}};
		System.out.println(allPathsSourceTarget(graph));
	}

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		List<List<Integer>> res = new ArrayList<>();

		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(0));

		int goal = graph.length - 1;

		while (!queue.isEmpty()) {
			List<Integer> path = queue.poll();
			int lastNode = path.get(path.size() - 1);

			if (lastNode == goal)
				res.add(new ArrayList<>(path));
			else {
				int[] neighbors = graph[lastNode];
				for (int neighbor : neighbors) {
					List<Integer> list = new ArrayList<>(path);
					list.add(neighbor);
					queue.add(list);
				}
			}
		}
		return res;
	}
}

//https://www.youtube.com/watch?v=CYnvDzMprdc&ab_channel=MichaelMuinos