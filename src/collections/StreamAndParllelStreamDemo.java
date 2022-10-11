package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//https://www.journaldev.com/2389/java-8-features-with-examples
//also see this https://www.journaldev.com/2774/java-8-stream
public class StreamAndParllelStreamDemo {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);

		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		// parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		// using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
		// using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));
		
		//Notice that parallel processing values are not in order, 
		//so parallel processing will be very helpful while working with huge collections.

	}

}
