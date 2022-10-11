package collections;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToSet {

	public static void main(String[] args) {

		Stream<Integer> stream = Stream.of(1,2,3,-3,2,-4);
		Set<Integer> set = stream.collect(Collectors.toSet());
		set.forEach(num ->System.out.println(num));
	}

}
