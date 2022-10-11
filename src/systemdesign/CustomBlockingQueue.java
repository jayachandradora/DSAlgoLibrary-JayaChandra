package systemdesign;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue {
	public static void main(String[] args) {

		BlockingQueueNew customBlockingQueue = new BlockingQueueNew();
		Thread producer = new Thread(new Producer(customBlockingQueue)); // Creating producer and consumer threads
		Thread consumer = new Thread(new Consumer(customBlockingQueue));

		producer.start();
		consumer.start();
	}
}

class BlockingQueueNew {

	final Lock lock = new ReentrantLock();
	final Condition produceCond = lock.newCondition(); // Conditions
	final Condition consumeCond = lock.newCondition();

	final Object[] array = new Object[6]; // Array to store element for CustomBlockingQueue
	int putIndex, takeIndex;
	int count;

	public void put(Object x) throws InterruptedException {

		lock.lock();
		try {
			while (count == array.length) 
				produceCond.await(); // Queue is full, producers need to wait
			
			array[putIndex] = x;
			System.out.println("Producing - " + x);
			putIndex++;
			if (putIndex == array.length) 
				putIndex = 0;
			
			++count; // Increment the count for the array
			consumeCond.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0) 
				consumeCond.await(); // Queue is empty, consumers need to wait
			
			Object x = array[takeIndex];
			System.out.println("Consuming - " + x);
			takeIndex++;
			
			if (takeIndex == array.length) 
				takeIndex = 0;
			
			--count; // reduce the count for the array
			produceCond.signal(); // send signal producer
			return x;
		} finally {
			lock.unlock();
		}
	}
}

class Producer implements Runnable {

	private BlockingQueueNew customBlockingQueue;

	public Producer(BlockingQueueNew customBlockingQueue) {
		this.customBlockingQueue = customBlockingQueue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				customBlockingQueue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueueNew customBlockingQueue;

	public Consumer(BlockingQueueNew customBlockingQueue) {
		this.customBlockingQueue = customBlockingQueue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				customBlockingQueue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}