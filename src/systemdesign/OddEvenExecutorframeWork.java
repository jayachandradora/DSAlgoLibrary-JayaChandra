package systemdesign;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenExecutorframeWork {
	private static final int TOTAL_NUMBER_OF_THREADS = 2;

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_NUMBER_OF_THREADS);

		OddEvenRunnable oddRunnable = new OddEvenRunnable(1);
		OddEvenRunnable evenRunnable = new OddEvenRunnable(0);

		Thread t1 = new Thread(oddRunnable, "Odd");
		Thread t2 = new Thread(evenRunnable, "Even");

		executorService.submit(t1);
		executorService.submit(t2);
		executorService.shutdown();

	}
}

class OddEvenRunnable implements Runnable {

	public int PRINT_NUMBERS_UPTO = 10;
	static int number = 1;
	int remainder;
	static Object lock = new Object();

	OddEvenRunnable(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO) {
			synchronized (lock) {
				if (number % 2 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}
}