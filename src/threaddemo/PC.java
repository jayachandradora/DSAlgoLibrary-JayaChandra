package threaddemo;

import java.util.concurrent.Semaphore;

public class PC {
	public static void main(String[] args) {
		Q q = new Q();
		new Producer5(q);
		new Consumer5(q);
	}
}

class Q {

	int item;
	static Semaphore semConsumer = new Semaphore(0);
	static Semaphore semProducer = new Semaphore(1);

	public void put(int item) {
		// Before producer can produce an item,
		// it must acquire a permit from semProd
		try {
			semProducer.acquire();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		this.item = item;
		System.out.println("Producer produced the item " + item);
		semConsumer.release();
	}

	public void get() {
		// Before consumer can consume an item,
		// it must acquire a permit from semCon
		try {
			semConsumer.acquire();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Consumer consumed the item " + item);
		// After producer produces the item,
		// it releases semCon to notify consumer
		semProducer.release();
	}
}

class Consumer5 implements Runnable {
	Q q;
	public Consumer5(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++)
			q.get();
	}
}

class Producer5 implements Runnable {
	Q q;
	public Producer5(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++)
			q.put(i);
	}
}
