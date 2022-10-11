package threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemp {
	// Maximum number of threads in thread pool
	static final int MAX_T = 3;

	public static void main(String[] args) {
		// creates five tasks
		Runnable r1 = new Task1("task 1");
		Runnable r2 = new Task1("task 2");
		Runnable r3 = new Task1("task 3");
		Runnable r4 = new Task1("task 4");
		Runnable r5 = new Task1("task 5");

		// creates a thread pool with MAX_T no. of
		// threads as the fixed pool size(Step 2)
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
		//Executors.newScheduledThreadPool(4);
		
		// passes the Task objects to the pool to execute (Step 3)
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);

		// pool shutdown ( Step 4)
		pool.shutdown();
	}
}

// Task class to be executed (Step 1)
class Task1 implements Runnable {
	private String name;

	public Task1(String s) {
		name = s;
	}
	// Prints task name and sleeps for 1s
	// This Whole process is repeated 5 times
	public void run() {
		try {
			for (int i = 0; i <= 5; i++) {
				System.out.println("Number of times " + i);
				Thread.sleep(1000);
			}
			System.out.println(name + " complete");
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
