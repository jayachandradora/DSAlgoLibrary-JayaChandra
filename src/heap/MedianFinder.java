package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	PriorityQueue<Integer> maxheap = new PriorityQueue<>();// heap is a minimal heap by default
	PriorityQueue<Integer> minheap = new PriorityQueue<>(Collections.reverseOrder());// change to a maximum heap

	 public void addNum(int num) {
	        if(maxheap.isEmpty()|| num < maxheap.peek())  
				maxheap.add(num);
			else
				minheap.add(num);						  
				
			if(minheap.size() > maxheap.size() + 1)
				maxheap.add(minheap.poll());
				
			if(maxheap.size() > minheap.size() + 1)
				minheap.add(maxheap.poll());
	    }
	    
	    public double findMedian() {
	        
	        if(maxheap.size() == minheap.size())
				return (maxheap.peek() + minheap.peek())/2.0;
			
			if(maxheap.size()> minheap.size())
				return maxheap.peek();
			else
				return minheap.peek();
	    }
	
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(2);
		mf.addNum(3);
		mf.addNum(4);
		System.out.println(mf.findMedian());
		mf.addNum(5);
		System.out.println(mf.findMedian());
	}

}


/**
 // Adds a number into the data structure.
	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if (maxHeap.size() < minHeap.size())
			maxHeap.offer(minHeap.poll());
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (maxHeap.size() == minHeap.size())
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		else
			return maxHeap.peek();
	}
 **/