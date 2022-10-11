package threaddemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		// Creating BlockingQueue of size 10
		BlockingQueue<MessageJC> queue = new ArrayBlockingQueue<>(8);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		// starting producer to produce messages in queue
		new Thread(producer).start();
		// starting consumer to consume messages from queue
		new Thread(consumer).start();
		System.out.println("Producer and Consumer has been started");
	}
}

class Consumer implements Runnable {

	private BlockingQueue<MessageJC> queue;

	public Consumer(BlockingQueue<MessageJC> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		try {
			MessageJC msg;
			// consuming messages until exit message is received
			while ((msg = queue.take()).getMsg() != "exit") {
				Thread.sleep(10000);
				System.out.println("Consumed " + msg.getMsg());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable {

	private BlockingQueue<MessageJC> queue;

	public Producer(BlockingQueue<MessageJC> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		// produce messages
		for (int i = 0; i < 5; i++) {
			MessageJC msg = new MessageJC("" + i);
			try {
				Thread.sleep(2000);
				queue.put(msg);
				System.out.println("Produced " + msg.getMsg());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// adding exit message
		MessageJC msg = new MessageJC("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MessageJC {
	private String msg;

	public MessageJC(String str) {
		this.msg = str;
	}

	public String getMsg() {
		return msg;
	}
}