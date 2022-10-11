package matrix.vision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
		/*Scanner scanner = new Scanner(System.in);
		int numLines = Integer.parseInt(scanner.nextLine());
		int currentLine = 0;
		while (currentLine++ < numLines) {
			final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
			final Set<String> apps = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			for (int i = 0; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String app = tokens[0];
				apps.add(app);
				final int runs = Integer.parseInt(tokens[1]);

				stats.putNewRating(app, runs);

			}
			
			Set<String> apps = new TreeSet<>();
			
			stats.putNewRating("gmail", 5);
			stats.putNewRating("faceBook", 2);

			stats.putNewRating("gmail", 7);
			stats.putNewRating("faceBook", 3);
			stats.putNewRating("gmail", 1);
			
			apps.add("gmail");
			apps.add("faceBook");


			for (String app : apps) {
				System.out.println(
						String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
			}

		}
		scanner.close();*/
		Set<String> apps = new TreeSet<>();
		
		stats.putNewRating("gmail", 5);
		stats.putNewRating("faceBook", 2);

		stats.putNewRating("gmail", 7);
		stats.putNewRating("faceBook", 3);
		stats.putNewRating("gmail", 1);
		
		apps.add("gmail");
		apps.add("faceBook");


		for (String app : apps) {
			System.out.println(
					String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
		}

	}

	public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {

		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();

		@Override
		public void putNewRating(String app, int rating) {
			if (map.containsKey(app))
				map.put(app, map.get(app) + rating);
			else
				map.put(app, rating);
			list.add(app);
		}

		@Override
		public double getAverageRating(String app) {
			float rating = map.get(app);
			return rating/getRatingsCount(app);
		}

		@Override
		public int getRatingsCount(String app) {
			int count = 0;
			for(String ls : list)
				if(ls.equalsIgnoreCase(app))
					count++;
			return count;
		}
	}

}

interface RatingStatisticsCollector {
	// Ratings feed will call this method when new app rating information is
	// received. This is input to your class. ratings is a non negative integer
	// between 0 to 10.
	public void putNewRating(String app, int rating);

	// Report the average rating of the app.
	public double getAverageRating(String app);

	// Report the total number of rating for an app.
	public int getRatingsCount(String app);
}