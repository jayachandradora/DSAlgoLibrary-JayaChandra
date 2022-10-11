package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ValidPath {

	public static boolean validPath(int n, int[][] edges, int start, int end) {
		
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] e : edges) {
			
			if (!map.containsKey(e[0]))
				map.put(e[0], new HashSet<>());
			
			if (!map.containsKey(e[1]))
				map.put(e[1], new HashSet<>());
			
			map.get(e[0]).add(e[1]);
			map.get(e[1]).add(e[0]);
		}

		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (curr == end)
				return true;
			visited.add(curr);
			for (Integer next : map.get(curr)) {
				if (visited.contains(next))
					continue;
				queue.add(next);
			}
		}

		return false;
	}

	public static void main(String[] args) {

		int n =3;
		int start = 0;
		int end = 2;
		int edges[][] = {{0,1},{1,2},{2,0}};
		System.out.println(validPath(n, edges, start, end));
	}

}
