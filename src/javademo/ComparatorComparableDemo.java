package javademo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//To summarize, if sorting of objects needs to be based on 
//natural order(means the object itself must know how it is to be ordered)then use Comparable 
//whereas if you sorting needs to be done on attributes of different objects, then use Comparator in Java.

public class ComparatorComparableDemo {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("Force Awakens", 8.3, 2015));
		list.add(new Movie("Star Wars", 8.7, 1977));
		list.add(new Movie("Empire Strikes Back", 8.8, 1980));
		list.add(new Movie("Return of the Jedi", 8.4, 1983));

		// Sort by rating : (1) Create an object of ratingCompare
		// (2) Call Collections.sort
		// (3) Print Sorted list
		System.out.println("Sorted by rating");
		RatingCompare ratingCompare = new RatingCompare();
		Collections.sort(list, ratingCompare);
		for (Movie movie : list)
			System.out.println(movie.getRating() + " " + movie.getName() + " " + movie.getYear());

		// Call overloaded sort method with RatingCompare
		// (Same three steps as above)
		System.out.println("\nSorted by name");
		NameCompare nameCompare = new NameCompare();
		Collections.sort(list, nameCompare);
		for (Movie movie : list)
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());

		// Uses Comparable to sort by year
		System.out.println("\nSorted by year");
		Collections.sort(list);
		for (Movie movie : list)
			System.out.println(movie.getYear() + " " + movie.getRating() + " " + movie.getName() + " ");
	}
}

// A class 'Movie' that implements Comparable
class Movie implements Comparable<Movie> {
	private double rating;
	private String name;
	private int year;

	// Used to sort movies by year
	public int compareTo(Movie m) {
		return this.year - m.year;
	}

	public Movie(String nm, double rt, int yr) {
		this.name = nm;
		this.rating = rt;
		this.year = yr;
	}

	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}
}

// Class to compare Movies by ratings
class RatingCompare implements Comparator<Movie> {
	public int compare(Movie m1, Movie m2) {
		if (m1.getRating() < m2.getRating())
			return -1;
		if (m1.getRating() > m2.getRating())
			return 1;
		else
			return 0;
	}
}

// Class to compare Movies by name
class NameCompare implements Comparator<Movie> {
	public int compare(Movie m1, Movie m2) {
		return m1.getName().compareTo(m2.getName());
	}
}