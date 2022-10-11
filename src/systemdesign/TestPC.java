package systemdesign;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class TestPC {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(1);

		ExecutorService ex = Executors.newFixedThreadPool(2);

		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				// Simulate a long-running Job
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
				System.out.println("I'll run in a separate thread than the main thread.");
			}
		});

		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
				return "Result of the asynchronous computation";
			}
		});

		ex.execute(new Runnable() {

			@Override
			public void run() {
				int count = 0;
				while (true) {
					if (count == 10)
						break;

					System.out.println("producer produce data ");
					Random random = new Random();
					try {
						blockingQueue.put(random.nextInt(10));
						count++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		ex.execute(new Runnable() {
			public void run() {
				int count = 0;
				while (true) {

					if (count == 10)
						break;

					try {
						System.out.println("Consumer Recived " + blockingQueue.take());
						Thread.sleep(1000);
						count++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		ex.shutdown();

		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(getSupplier()).thenApply(x -> {
			return x;
		});

		try {
			System.out.println("Thanks a lot blocking operation " + future3.get());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}
	

	public static Supplier<String> getSupplier() {

		return new Supplier<String>() {

			@Override
			public String get() {
				return "jd";
			}
		};

	}

}

@FunctionalInterface
interface Square {
	int calculate(int x);
}