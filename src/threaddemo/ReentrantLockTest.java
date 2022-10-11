package threaddemo;

/*Steps to implement 

1. Create an object of ReentrantLock
2. Create a worker(Runnable Object) to execute and pass the lock to the object
3. Use the lock() method to acquire the lock on shared resource
4. After completing work, call unlock() method to release the lock */

//Java code to illustrate Reentrant Locks
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class worker1 implements Runnable {
	String name;
	ReentrantLock re;

	public worker1(ReentrantLock rl, String n) {
		re = rl;
		name = n;
	}

	public void run() {
		boolean done = false;
		while (!done) {
			// Getting Outer Lock
			boolean ans = re.tryLock();

			// Returns True if lock is free
			if (ans) {
				try {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println(
							"task name - " + name + " outer lock acquired at " + ft.format(d) + " Doing outer work");
					Thread.sleep(1500);

					// Getting Inner Lock
					re.lock();
					try {
						d = new Date();
						ft = new SimpleDateFormat("hh:mm:ss");
						System.out.println("task name - " + name + " inner lock acquired at " + ft.format(d)
								+ " Doing inner work");
						System.out.println("Lock Hold Count - " + re.getHoldCount());
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						// Inner lock release
						System.out.println("task name - " + name + " releasing inner lock");

						re.unlock();
					}
					System.out.println("Lock Hold Count - " + re.getHoldCount());
					System.out.println("task name - " + name + " work done");

					done = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					// Outer lock release
					System.out.println("task name - " + name + " releasing outer lock");

					re.unlock();
					System.out.println("Lock Hold Count - " + re.getHoldCount());
				}
			} else {
				System.out.println("task name - " + name + " waiting for lock");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class ReentrantLockTest {
	static final int MAX_T = 2;

	public static void main(String[] args) {
		ReentrantLock rel = new ReentrantLock();
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
		Runnable w1 = new worker1(rel, "Job1");
		Runnable w2 = new worker1(rel, "Job2");
		Runnable w3 = new worker1(rel, "Job3");
		Runnable w4 = new worker1(rel, "Job4");
		X x = new X();
		x.setName("hi");
		
		pool.execute(w1);
		pool.execute(w2);
		pool.execute(w3);
		pool.execute(w4);
		pool.shutdown();
	}
}

class X extends Thread{
	public void run(){
		System.out.println("Hi");
	}
}