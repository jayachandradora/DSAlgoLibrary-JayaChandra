package systemdesign;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomExecutorServiceExample {

	public static void main(String[] args) {

		CallableTask callTast = new CallableTask();
		RunnableTask runTask = new RunnableTask();

		ExecutorService exec = Executors.newFixedThreadPool(3);

		try {
			exec.submit(runTask);
			exec.submit(callTast);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

interface ExecutorService {
	public void submit(Object o) throws InterruptedException;
}

class MyFixedThreadPool implements ExecutorService {

	int capacity;
	LinkedBlockingQueue linkedBlockingQueue;

	public MyFixedThreadPool(int capacity) {
		this.capacity = capacity;
		linkedBlockingQueue = new LinkedBlockingQueue(capacity);
	}

	@Override
	public void submit(Object o) throws InterruptedException {
		if (linkedBlockingQueue.size() != capacity) {
			linkedBlockingQueue.add(o);
			new Execution(linkedBlockingQueue).runTask();
		}else
			this.wait();
	}
}

class Execution extends Thread {
	LinkedBlockingQueue linkedBlockingQueue;

	Execution(LinkedBlockingQueue linkedBlockingQueue) {
		this.linkedBlockingQueue = linkedBlockingQueue;
	}

	public void runTask() {
		
		Object obj = linkedBlockingQueue.poll();
		Runnable task ;
		Callable callTask = null;
		if(obj instanceof RunnableTask )
			task = (Runnable)linkedBlockingQueue.poll();
		else 
			 callTask = (Callable)linkedBlockingQueue.poll();;
	}

}

class Executors {
	int capacity = 0;

	static ExecutorService newFixedThreadPool(int size) {
		return new MyFixedThreadPool(size);
	}
}

class CallableTask implements Callable {

	@Override
	public Object call() throws Exception {
		System.out.println("Callable Task: ");
		return null;
	}

}

class RunnableTask implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable Task: ");
	}
}
