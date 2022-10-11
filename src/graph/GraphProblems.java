package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.youtube.com/watch?v=vRlaZ7Sh42Y&list=PLt4nG7RVVk1geg-Y5VOa9dDM0kKKMFWZo&index=4
class Graph2 {
	  List<List<Integer>> graph;
	  boolean visited[];

	  Graph2(int nodes) {
	    graph = new ArrayList<>();
	    visited = new boolean[nodes];

	    for (int i = 0; i < nodes; i++) {
	      graph.add(i, new ArrayList<>());
	    }
	  }

	  public void addEdge(int a, int b) {
	    graph.get(a).add(b);
	    graph.get(b).add(a);
	  }

	  public void dfs(int start) {
	    Stack<Integer> stack = new Stack<>();
	    
	    stack.push(start);
	    visited[start] = true;
	    
	    while(!stack.isEmpty()) {
	      Integer node = stack.pop();
	      System.out.print(node + " ");
	      
	      List<Integer> neighboursList = graph.get(node);
	      
	      for(Integer neighbour: neighboursList) {
	        if(!visited[neighbour]) {
	          stack.push(neighbour);
	          visited[neighbour] = true;
	        }
	      }
	    }
	  }
	}

	public class GraphProblems {

	  public static void main(String[] args) {
	    int nodes = 7;
	    
	    Graph2 a = new Graph2(nodes);
	    
	    a.addEdge(0, 1);
	    a.addEdge(0, 2);
	    a.addEdge(1, 3);
	    a.addEdge(2, 4);
	    a.addEdge(3, 5);
	    a.addEdge(4, 5);
	    a.addEdge(4, 6);

	    a.dfs(0);
	  }


}
