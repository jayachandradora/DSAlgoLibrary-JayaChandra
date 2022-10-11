package systemdesign;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SequenceNumberThread {

	public static void main(final String[] arguments) throws InterruptedException {

		int numberOfThread = 3;
		ExecutorService fixedPool = Executors.newFixedThreadPool(3);
		NumberSequenceThread ist = new NumberSequenceThread(1, "1st", numberOfThread);
		NumberSequenceThread second = new NumberSequenceThread(2, "2nd", numberOfThread);
		NumberSequenceThread third = new NumberSequenceThread(0, "3rd", numberOfThread);

		Thread istT = new Thread(ist, "ist");
		Thread secondT = new Thread(second, "second");
		Thread thirdT = new Thread(third, "third");

		fixedPool.submit(istT);
		fixedPool.submit(secondT);
		fixedPool.submit(thirdT);
		
		fixedPool.shutdown();
	}
}

class NumberSequenceThread implements Runnable {

	int reminder = 0;
	static int number = 1;
	int total = 10;
	static Object lock = new Object();
	String name = null;
	int numberOfThread =0;
	
	NumberSequenceThread(int reminder, String name, int numberOfThread) {
		this.reminder = reminder;
		this.name = name;
		this.numberOfThread = numberOfThread;
	}

	@Override
	public void run() {
		while (number < total) {
			synchronized (lock) {
				if (number % numberOfThread != reminder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(name + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}

}