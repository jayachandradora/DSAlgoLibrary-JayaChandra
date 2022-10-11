package threaddemo;

import java.util.LinkedList;
import java.util.Queue;

public class TestThread extends Thread {

	public static void main(String args[]) throws InterruptedException {
		ThreadPool1 tp = new ThreadPool1(3, 4);
		Task112 task = null;
		for (int i = 0; i < 7; i++) {
			task = new Task112(i);
			tp.enqueue(task);
		}
	}
}

class ThreadPool1 {
	BlockingQueue<Runnable> bq;

	ThreadPool1(int queueSize, int nThread) {
		bq = new BlockingQueue<>(queueSize);
		String threadName = null;
		TaskExecutor task = null;
		for (int i = 0; i < queueSize; i++) {
			threadName = "Thread Count " + i;
			task = new TaskExecutor(bq);
			Thread thread = new Thread(task, threadName);
			thread.start();
		}
	}

	public void enqueue(Runnable task) throws InterruptedException {
		bq.enque(task);
	}
}

class TaskExecutor implements Runnable {

	BlockingQueue<Runnable> bq;

	TaskExecutor(BlockingQueue<Runnable> blockingQueue) {
		this.bq = blockingQueue;
	}

	@Override
	public void run() {
		try {
			String name = Thread.currentThread().getName();
			Runnable task = bq.dequeue();
			System.out.println("Task started by name " + name);
			task.run();
			System.out.println("Task finished by thread " + name);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

class Task112 implements Runnable {

	int number;

	Task112(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		System.out.println("Start executing tasks " + number);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End executing tasks " + number);
	}
}

class BlockingQueue<Type> {

	private Queue<Type> queue = new LinkedList<>();
	private int empty;
	int MAX_QUEUE_SIZE = -1;

	BlockingQueue(int size) {
		this.MAX_QUEUE_SIZE = size;
	}

	public synchronized void enque(Type task) throws InterruptedException {
		while (this.queue.size() == this.MAX_QUEUE_SIZE)
			wait();

		if (this.queue.size() == empty)
			notifyAll();

		this.queue.offer(task);
	}

	public synchronized Type dequeue() throws InterruptedException {
		while (this.queue.size() == empty)
			wait();

		if (this.queue.size() == this.MAX_QUEUE_SIZE)
			notifyAll();

		return this.queue.poll();
	}
}
