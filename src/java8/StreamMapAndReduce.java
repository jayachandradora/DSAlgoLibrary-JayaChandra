package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMapAndReduce {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		
		list.stream().filter(i -> i %2 ==0).forEach(i ->System.out.println(i));
		
		int myArray[] = { 1, 5, 8 };
		int sum = Arrays.stream(myArray).sum();
		  System.out.println(sum);
		
		System.out.println(Arrays.stream(myArray).reduce(0, (c,e) ->c+e));
		
		
		String[] myArray1 = { "this", "is", "a", "sentence" };
		String result = Arrays.stream(myArray1)
		                .reduce("", (a,b) -> a + b);
		
		System.out.println(result);
		
		Arrays.stream(myArray).map(i -> i*2).forEach(i ->System.out.println(i));
		
		System.out.println(Arrays.stream(myArray).filter(i ->i%3 == 0).findFirst().orElse(10));
		
		String s = "heloo sir thanks a lot";
	}

}
