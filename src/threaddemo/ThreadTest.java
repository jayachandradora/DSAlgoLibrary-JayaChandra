package threaddemo;

import java.util.concurrent.CyclicBarrier;

public class ThreadTest {

	public static CyclicBarrier newBarrier = new CyclicBarrier(2);

	public static void main(String[] args) throws InterruptedException {

		WrkThread w1 = new WrkThread(1);
		w1.setName("ODD");
		WrkThread w2 = new WrkThread(0);
		w2.setName("EVEN");

		w1.start();
		w2.start();

		System.out.println(Thread.currentThread().getName() + " has finished");
	}
}

class WrkThread extends Thread {

	int reminder;
	int number = 1;
	int MAX_NUMBER = 10;
	static Object lock = new Object();

	public WrkThread(int reminder) {
		this.reminder = reminder;
	}

	@Override
	public void run() {
		while (number < MAX_NUMBER) {
			synchronized (lock) {
				if (number % 2 != reminder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + number);
				number++;
				lock.notifyAll();
			}

		}

	}
}
