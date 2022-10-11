package intv.str_arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

//https://www.youtube.com/watch?v=ZOP43iB_E_8&ab_channel=CodingDecoded
public class JobScheduling {

	public static void main(String[] args) {
		int startTime[] = { 1, 2, 3, 4, 6 }, endTime[] = { 3, 5, 10, 6, 9 }, profit[] = { 20, 20, 100, 70, 60 };
		JobScheduling js = new JobScheduling();
		System.out.println(" Maximum Profit " + js.jobScheduling(startTime, endTime, profit));
	}

	private class Job {
		private int startTime;

		private int endTime;
		private int profit;

		public Job(int sT, int eT, int p) {

			this.startTime = sT;
			this.endTime = eT;
			this.profit = p;

		}
	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		List<Job> jobs = new ArrayList<>();
		for (int i = 0; i < startTime.length; i++) {
			jobs.add(new Job(startTime[i], endTime[i], profit[i]));
		}

		Collections.sort(jobs, (a, b) -> (a.endTime - b.endTime));
		// Key => Time, Value => profitTillTime
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int ans = 0;

		for (Job currJob : jobs) {
			Integer entryTillStartTime = map.floorKey(currJob.startTime);
			int maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
			ans = Math.max(ans, maxProfitTillStartTime + currJob.profit);
			map.put(currJob.endTime, ans);
		}
		return ans;
	}

}

/** Soln
  { 1, 2, 3, 4, 6 },
 { 3, 5, 10, 6, 9 }, 
 { 20, 20, 100, 70, 60};
 
 3 -> 20
 5 -> 20
 10 -> 100
 6 -> 90 (20 + 70)
 9 -> 150(90 + 60)
 **/
