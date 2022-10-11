package arrays;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SimulateOutOfMemoryError {

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 11; i++)
			System.out.println("random number " + new Random().nextInt(10));

		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		for (int i = 0; i < 11; i++)
			System.out.println("random between " + tlr.nextInt(5, 7));

		int dummyArraySize = 15;
		System.out.println("Max JVM memory: " + Runtime.getRuntime().maxMemory());
		long memoryConsumed = 0;
		try {
			long[] memoryAllocated = null;
			for (int loop = 0; loop < Integer.MAX_VALUE; loop++) {
				memoryAllocated = new long[dummyArraySize];
				memoryAllocated[0] = 0;
				memoryConsumed += dummyArraySize * Long.SIZE;
				System.out.println("Memory Consumed till now: " + memoryConsumed);
				dummyArraySize *= dummyArraySize * 2;
				Thread.sleep(500);
			}
		} catch (OutOfMemoryError outofMemory) {
			System.out.println("Catching out of memory error");
			// Log the information,so that we can generate the statistics (latter on).
			throw outofMemory;
		}
	}

	public void disp() {
		Thread th = new Thread(() -> System.out.println("hellow"));
		th.start();
	}

	public void d() {
		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("");

			}
		});
	}
}
