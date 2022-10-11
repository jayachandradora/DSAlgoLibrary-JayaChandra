package heap;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MeetingRoom {

	public static void main(String[] args) {

		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);
		System.out.println("Min no of meeting rooms required is " + findMinNoOfMeetingRooms(intervals));

		System.out.println(canAttendMeetings(intervals));
		//System.out.print(LocalDate.now().plusDays(1));
		
		int intervals1[][] = {{0,30}, {5, 10},{15, 20}};
		System.out.println(findMinNoOfMeetingRoomsApp2(intervals1));

	}

	static boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}
		return true;
	}

	public static int findMinNoOfMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int count = 1;
		queue.offer(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < queue.peek()) {
				count++;
			} else {
				queue.poll();
			}
			queue.offer(intervals[i].end);
		}

		return count;
	}

	//JD this approach follow -- very good
	public static int findMinNoOfMeetingRoomsApp2(int[][] intervals) {

		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int intv[] : intervals) {

			if (pq.isEmpty()) {
				pq.add(intv[1]);
				continue;
			}

			if (pq.peek() <= intv[0])
				pq.poll();

			pq.add(intv[1]);
		}
		return pq.size();
	}
}

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
