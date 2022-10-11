package systemdesign;

import java.util.LinkedList;
import java.util.List;

//https://www.javacodemonk.com/blocking-queue-implementation-in-java-044ee033
public class CustomBlockingQueueExample {

	public static void main(String args[]) throws InterruptedException {
		CustomBlockingQueue11<Integer> cbq = new CustomBlockingQueueImpl<Integer>(10);
		System.out.println("Add data");
		cbq.put(10);
		cbq.take();
		cbq.put(20);
		cbq.take();
		cbq.take();
		cbq.take();
	}
}

interface CustomBlockingQueue11<T> {

	void put(T t) throws InterruptedException;
	T take() throws InterruptedException;
}

class CustomBlockingQueueImpl<T> implements CustomBlockingQueue11<T> {

	int capacity = 0;
	List<T> queue = null;
	//Object obj = new Object();

	public CustomBlockingQueueImpl(int size) {
		this.capacity = size;
		this.queue = new LinkedList<T>();
	}

	@Override
	public synchronized void put(T msg) throws InterruptedException {

		if (queue.size() == capacity)
			this.wait();

		queue.add(msg);
		this.notify();
	}

	@Override
	public synchronized T take() throws InterruptedException {
		if (queue.size() == 0)
			this.wait();

		T t = queue.remove(0);
		System.out.println(t);
		this.notify();
		return t;
	}

}