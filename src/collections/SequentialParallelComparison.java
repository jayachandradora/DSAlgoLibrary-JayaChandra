package collections;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

//https://www.logicbig.com/tutorials/core-java-tutorial/java-util-stream/sequential-vs-parallel.html
public class SequentialParallelComparison {

	public static void main(String[] args) {
		String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		System.out.println("-------\nRunning sequential\n-------");
		run(strings, true);
		System.out.println("-------\nRunning normal forloop\n-------");
		run(strings, false);

		System.out.println("-------\nRunning parallel\n-------");
		runParlel(Arrays.stream(strings).parallel());
	}

	public static void run(String[] strings, boolean isStream) {

		long cur = System.currentTimeMillis();
		Arrays.stream(strings).sequential();
		System.out.println(System.currentTimeMillis() - cur);
		
		Stream stream = Arrays.stream(strings).sequential();
		if (isStream) {
			stream.forEach(s -> {
				System.out.println(LocalTime.now() + " - value: " + s + 
						" - thread: " + Thread.currentThread().getName());
			});
		} else {
			for (String s : strings)
				System.out.println(s);
		}

		System.out.println(System.currentTimeMillis() - cur);
	}

	public static void runParlel(Stream<String> stream) {

		long cur = System.currentTimeMillis();
		stream.forEach(s -> {
			System.out.println(LocalTime.now() + " - value: " + s + " - thread: " 
					+ Thread.currentThread().getName());
		});

		System.out.println(System.currentTimeMillis() - cur);
	}
}
