package collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String args[]){
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0;i<5;i++)
			queue.add(i);
		System.out.println("Print Queue " + queue);
		
		int removedItem = queue.remove();
		System.out.println("Removed item " + removedItem);
		System.out.println("Print Queue post removed item " + queue);
		
		int head = queue.peek();
		System.out.println("Peek item " + head);
		
		int size = queue.size();
		System.out.println("Size of Queue " + size);
		
	}
}
