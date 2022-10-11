package threaddemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelProcessingExample {

	public static void main(String[] args) throws Exception {

		ParallelTasks tasks = new ParallelTasks();

		final Runnable waitOneSecond = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		};

		tasks.add(waitOneSecond);
		tasks.add(waitOneSecond);
		tasks.add(waitOneSecond);
		tasks.add(waitOneSecond);

		final long start = System.currentTimeMillis();
		tasks.go();
		System.err.println(System.currentTimeMillis() - start);
	}
}

class ParallelTasks {
	private final Collection<Runnable> tasks = new ArrayList<Runnable>();

	public ParallelTasks() {

	}

	public void add(final Runnable task) {
		tasks.add(task);
	}

	public void go() throws InterruptedException {
		final ExecutorService threads = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		try {
			final CountDownLatch latch = new CountDownLatch(tasks.size());
			for (final Runnable task : tasks)
				threads.execute(new Runnable() {
					public void run() {
						try {
							task.run();
						} finally {
							latch.countDown();
						}
					}
				});
			latch.await();
		} finally {
			threads.shutdown();
		}
	}
}