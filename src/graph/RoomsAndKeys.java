package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoomsAndKeys {

	public static void main(String[] args) {

		//[[1,3],[3,0,1],[2],[0]]
		List<Integer> keys0 = new ArrayList<Integer>();
		keys0.add(1);
		keys0.add(3);
		
		List<Integer> keys1 = new ArrayList<Integer>();
		keys1.add(3);
		keys1.add(0);
		keys1.add(1);
		List<Integer> keys2 = new ArrayList<Integer>();
		keys2.add(2);
		List<Integer> keys3 = new ArrayList<Integer>();
		keys3.add(0);
		List<List<Integer>> rooms = new ArrayList<>();
		rooms.add(keys0);
		rooms.add(keys1);
		rooms.add(keys2);
		rooms.add(keys3);
		
		System.out.println(canVisitAllRooms(rooms));
		
	}

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[rooms.size()];
        
        visited[0] = true;
        for(int i : rooms.get(0)) {
            queue.add(i);
            visited[i] = true;
        }
        
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i : rooms.get(temp)) {
                if(visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        
        for (int i = 1; i < visited.length; i++) 
            if(visited[i] == false) 
            	return false;
        
        
        return true;
    }
}
