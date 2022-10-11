package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

	public static void main(String[] args) {

		List<String> lst = new ArrayList<>();
		lst.add("JC");
		lst.add("Ishu");
		lst.add("Suji");
		Sorting.sortUsingJava8(lst);
		for(String st : lst)
			System.out.println(st);
	}

	//sort using java 8
	private static void sortUsingJava8(List<String> names) {
	  Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	  names.stream().filter(s -> s.equalsIgnoreCase("ishu") || s.equalsIgnoreCase("jc")).
	  map(String :: toUpperCase).forEach(System.out :: println);
	}
}
