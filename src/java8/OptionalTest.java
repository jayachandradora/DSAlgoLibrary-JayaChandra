package java8;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalTest {
	public static void main(String args[]) {
		OptionalTest java8Tester = new OptionalTest();
	      Integer value1 = null;
	      Integer value2 = new Integer(10);
			
	      //Optional.ofNullable - allows passed parameter to be null.
	      Optional<Integer> a = Optional.ofNullable(value1);
			
	      //Optional.of - throws NullPointerException if passed parameter is null
	      Optional<Integer> b = Optional.of(value2);
	      System.out.println(java8Tester.sum(a,b));
	      
	      //String str = (String)Optional.ofNullable(null).orElseThrow(IllegalArgumentException::new);
	      //System.out.println("null able " + str);
	      
	      Integer year = 2016;
	      Optional<Integer> yearOptional = Optional.of(year);
	      boolean is2016 = yearOptional.filter(y -> y == Year.now().getValue()).isPresent();
	      System.out.println("Current Year " + is2016 + " Print current Year " + Year.now().getValue());
	      
	      List<String> alpha = Arrays.asList("a", "b", "c", "d");
	      List<String> collect = alpha.stream().map(String :: toUpperCase).collect(Collectors.toList());
	      collect.stream().forEach(num -> System.out.println(num));

	      List<Integer> intlist = Arrays.asList(1,3,5,6,6);
	      System.out.println(intlist.stream().mapToInt(i -> i*2).sum());
	
	}
		
	   public Integer sum(Optional<Integer> a, Optional<Integer> b) {
	      //Optional.isPresent - checks the value is present or not
			
	      System.out.println("First parameter is present: " + a.isPresent());
	      System.out.println("Second parameter is present: " + b.isPresent());
			
	      //Optional.orElse - returns the value if present otherwise returns
	      //the default value passed.
	      Integer value1 = a.orElse(new Integer(0));
			
	      //Optional.get - gets the value, value should be present
	      Integer value2 = b.get();
	      return value1 + value2;
	   }
}
