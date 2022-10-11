package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		//list.forEach(i -> System.out.println(i));
		
		Consumer<Integer> c = new Consumer<Integer>(){
			@Override
			public void accept(Integer	i) {
				System.out.println(i);
			}
		};
		
		list.forEach(c); // its same as line number 12.
		
		//Predicate<Boolean> pr = p-> p == 3;
		//list.removeIf(i-> i == 3);
		
		list.forEach(StreamDemo::disp);
		
	}
	
	public static void disp(int i){
		System.out.println(i);
	}

}
