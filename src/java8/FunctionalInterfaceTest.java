package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FunctionalInterfaceTest implements Squre {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hi tttt");
			}
		}).start();
		new Thread(()->System.out.println("Java8 Hi ttttt")).start();
		
		function();

		Squre sq = (int a, int b) -> a * b;
		System.out.println(sq.calculate(5, 4));

		Consumer<Integer> in = i -> System.out.println("Consumer " + i);
		in.accept(sq.calculate(10, 20));

		Supplier<String> st = () -> " JD ";
		System.out.println("No Argument : " + st.get());

		Function<Integer, Integer> fun = (a) -> a / 2;
		System.out.println("Function " + fun.apply(7));

		function1();
		
		FunctionalInterfaceTest tst = new FunctionalInterfaceTest();
		tst.disp();
	}

	public void disp() {
		System.out.println("Default overrided method");
	}
	public static void function() {
		new Thread(() -> System.out.println("Lambda")).start();
	}

	public static void function1() {
		TestT tst = new TestT(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return Integer.compare(i2, i1);
			}
		});

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(2);
		
		list.parallelStream().map(a -> a*10).forEach(System.out :: println);
		List lst = list.stream().map(a -> a*10).collect(Collectors.toList());
		list.stream().forEach(i -> System.out.println(i));
		list.forEach(i -> System.out.println(i));
		

		list.removeIf((Integer t) -> t % 2 == 0);
		Queue<Integer> queue1 = new PriorityQueue<Integer>((Integer o1, Integer o2) -> o2 - o1);
		queue1.addAll(list);

		System.out.println("+++++++++++++++++++++");
		while (!queue1.isEmpty()) {
			System.out.println(queue1.poll());
		}
		System.out.println("Iteration through forEach Method ");
		list.forEach((a) -> System.out.println(a));
		list.parallelStream().filter(p -> p > 2).forEach(p -> System.out.println(p));
		list.stream().sequential().filter(p -> p > 2).forEach(p -> System.out.println(p));

		int arr[] = new int[3];
		arr[2] = 2;

		Optional<Integer> value = Optional.of(arr[1]);
		if (value.isPresent())
			System.out.println("get Method" + value.get());

		int min1 = Arrays.stream(new int[] {1 }).min().orElse(0);
		System.out.println(min1);
		
		Squre.add(1, 2);
		
		System.out.println("Available Processors " +Runtime.getRuntime().availableProcessors());
	}

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class TestT {
	public TestT(Comparator<Integer> cm) {

	}
}

@FunctionalInterface
interface Squre {
	int calculate(int a, int b);
	

	default void disp() {
		System.out.println("Default method");
	}

	static void add(int a, int b) {
		System.out.println(a + b);
	}
}

@FunctionalInterface
interface TestIt {
	void cal();
}
