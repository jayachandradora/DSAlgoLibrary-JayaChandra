package systemdesign;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomExecutorServiceExample1 {

	public static void main(String[] args) throws InterruptedException {

		CallableTask1 runTask1 = new CallableTask1(1);
		CallableTask1 runTask2 = new CallableTask1(2);
		CallableTask1 runTask3 = new CallableTask1(3);
		CallableTask1 runTask4 = new CallableTask1(4);
		CallableTask1 runTask5 = new CallableTask1(5);

		ExecutorService1 exec = Executors1.newFixedThreadPool(3);

		exec.submit(runTask1);
		exec.submit(runTask2);
		exec.submit(runTask3);
		exec.submit(runTask4);
		exec.submit(runTask5);
	}
}

interface ExecutorService1 {
	public void submit(Callable<Integer> task) throws InterruptedException;
}

class MyFixedThreadPool1 implements ExecutorService1 {

	int capacity;
	LinkedBlockingQueue<Callable<Integer>> linkedBlockingQueue;
	Execution1 exec = null;

	public MyFixedThreadPool1(int capacity) {
		this.capacity = capacity;
		linkedBlockingQueue = new LinkedBlockingQueue<Callable<Integer>>(capacity);
		exec = new Execution1(linkedBlockingQueue);
	}

	@Override
	public void submit(Callable<Integer> task) throws InterruptedException {

		Object objectLock = new Object();
		
		synchronized (objectLock) {

			if (linkedBlockingQueue.size() != capacity) {
				linkedBlockingQueue.add(task);
				try {
					exec.executeTask();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else
				objectLock.wait();
		}
	}
}

class Execution1 extends Thread {

	LinkedBlockingQueue<Callable<Integer>> linkedBlockingQueue;

	Execution1(LinkedBlockingQueue<Callable<Integer>> linkedBlockingQueue) {
		this.linkedBlockingQueue = linkedBlockingQueue;
	}

	void executeTask() throws Exception {
		Callable<Integer> runTask = (Callable<Integer>) linkedBlockingQueue.poll();
		System.out.println("executeTask() " + runTask.call());
	}

	public void run() {
		try {
			executeTask();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Executors1 {
	int capacity = 0;

	static ExecutorService1 newFixedThreadPool(int size) {
		return new MyFixedThreadPool1(size);
	}
}

class CallableTask1 implements Callable<Integer> {

	int val = 0;

	CallableTask1(int in) {
		this.val = in;
	}

	@Override
	public Integer call() {
		System.out.println("Inside CallableTask Task: " + val);
		return val;
	}
}
