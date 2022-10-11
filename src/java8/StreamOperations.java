package java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class StreamOperations {

	public static void main(String[] args) {

		// to calculate 20th element of Fibonacci-Series
		int number = 3;
		int poolSize = Runtime.getRuntime().availableProcessors();
		ForkJoinPool pool = new ForkJoinPool(poolSize);
		long beforeTime = System.currentTimeMillis();
		System.out.println("Parallelism  => " + pool.getParallelism());
		Integer result = (Integer) pool.invoke(new FibonacciComputation(number));
		System.out.println("Total Time in MilliSecond Taken ->  " + (System.currentTimeMillis() - beforeTime));
		System.out.println(number + "the element of Fibonacci Number = " + result);
		List<Integer> list = Arrays.asList(1,3,4,5,6,2);
		list.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
	}
}

class FibonacciComputation extends RecursiveTask<Integer> {
	private final int number;

	public FibonacciComputation(int number) {
		this.number = number;
	}

	@Override
	public Integer compute() {
		
		if (number <= 1)
			return number;
		FibonacciComputation f1 = new FibonacciComputation(number - 1);
		f1.fork();
		System.out.println("Current Therad Name = " + Thread.currentThread().getName());
		FibonacciComputation f2 = new FibonacciComputation(number - 2);
		return f2.compute() + (Integer) f1.join();
	}
}