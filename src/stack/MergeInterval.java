package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MergeInterval {

	public static void main(String[] args) {
		Interval in1 = new Interval(1, 3);
		Interval in3 = new Interval(8, 10);
		Interval in4 = new Interval(15, 18);
		Interval in2 = new Interval(2, 6);
		
		List<Interval> list = new ArrayList<Interval>();
		list.add(in1);
		list.add(in4);
		list.add(in3);
		list.add(in2);

		for (Interval in : mergeWithoutStack(list))
			System.out.println(in.start + " " + in.end);

	}

	public static List<Interval> merge(List<Interval> intervals) {
		Stack<Interval> stack = new Stack<>();
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		for (Interval it : intervals) {
			if (stack.isEmpty() || it.start > stack.peek().end)
				stack.push(it);
			else {
				stack.peek().end = Math.max(it.end, stack.peek().end);
				//intervals.remove(it);
			}
		}
		return new ArrayList<>(stack);
	}
	
	public static List<Interval> mergeWithoutStack(List<Interval> intervals) {
	    List<Interval> res = new ArrayList<>();
	    if(intervals == null || intervals.size() == 0) {
	        return res;
	    }
	    Collections.sort(intervals, (a, b) -> (a.start - b.start));
	    
	    Interval newInterval = intervals.get(0);
	    for(int i = 1; i < intervals.size(); i++) {
	        if(newInterval.end < intervals.get(i).start) {
	            res.add(newInterval);
	            newInterval = intervals.get(i);
	        } else {
	            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
	            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
	        }
	    }
	    res.add(newInterval);
	    return res;
	}
}
