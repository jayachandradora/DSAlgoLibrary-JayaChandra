package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StaticAndDefaultMethods implements Test {

	public static void main(String[] args) {

		Test.disp();
		StaticAndDefaultMethods sd = new StaticAndDefaultMethods();
		sd.show();

		TestInterface2 sd1 = new StaticAndDefaultMethods();
		sd1.show();

		//how to print 10 random number
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		//Random numbers with sorted form
		random.ints().limit(10).sorted().forEach(System.out::println);
		
		//Parallel Processing
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		//get count of empty string
		long count =strings.parallelStream().filter(i ->i.isEmpty()).count();
		System.out.println(count);

		strings.parallelStream().filter(i ->!i.isEmpty()).forEach(i -> System.out.println(i));
		
		//convert stream data to List
		List<String> list = strings.parallelStream().filter(i ->i.startsWith("a")).collect(Collectors.toList());
		System.out.println(list);
		
		//normal arr to list
		int arr[] = {1,3,4,5,2,6,6};
		List lst = Arrays.asList(arr, arr);
		System.out.println(lst);
	}
}

interface Test extends TestInterface2 {
	default void add(){
		System.out.println("add");
	}
	default void show() {
		System.out.println("Test Show");
	}

	static void disp() {
		System.out.println("disp");
	}
}

interface TestInterface2 {
	// Default method
	default void show() {
		System.out.println("Default TestInterface2");
	}
}

interface Vehicle {
	default void print() {
		System.out.println("I am a vehicle!");
	}
}

class Car implements Vehicle {
	public void print() {
		Vehicle.super.print();
	}
}