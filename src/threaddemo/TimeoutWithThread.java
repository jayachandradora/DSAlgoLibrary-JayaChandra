package threaddemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//https://zengcode.medium.com/executorservice-with-timeout-98befeab8f50
public class TimeoutWithThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		List<Future<String>> future = executor.invokeAll(Arrays.asList(new MyTask()), 2, TimeUnit.SECONDS); 
		// Timeout of 10 seconds.
		
		executor.shutdown();
		System.out.println("end => " + future.get(0).isCancelled());

		ExecutorService executor2 = Executors.newSingleThreadExecutor();
		List<Future<String>> future2 = executor2.invokeAll(Arrays.asList(new MyTask2()), 2, TimeUnit.SECONDS); 
		//Timeout of 10 seconds.
		
		executor2.shutdown();
		System.out.println("end2 => " + future2.get(0).isCancelled());

	}

	static class MyTask implements Callable<String> {

		public String call() throws Exception {
			Thread.sleep(1000000000);
			System.out.println("hello");
			return "hello";
		}
	}

	static class MyTask2 implements Callable<String> {

		public String call() throws Exception {
			// Thread.sleep(1000000000);
			System.out.println("hello2");
			return "hello2";
		}
	}
}
