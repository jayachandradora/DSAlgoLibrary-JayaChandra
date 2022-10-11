package bits;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {

		ExecutorService ex = Executors.newFixedThreadPool(2);
		OddEvenRunnable odd = new OddEvenRunnable(1, "Odd");
		OddEvenRunnable even = new OddEvenRunnable(0, "Even");
		
		Thread o1 = new Thread(odd, "Odd");
		Thread e1 = new Thread(even, "Even");
		
		ex.execute(o1);
		ex.execute(e1);
		ex.shutdown();
		
	}
}

class OddEvenRunnable implements Runnable{
	
	final int number = 10;
	static Object lock = new Object();
	static int num = 1;
	int reminder;
	String name = null;

	public OddEvenRunnable(int reminder, String name) {
		this.reminder = reminder;
		this.name = name;
	}
	@Override
	public void run() {
		
		while(num < number) {
			synchronized (lock) {
				
				if(num %2 != reminder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
					System.out.println(name +" " + num);
					num++;
					lock.notifyAll();
				
			}
		}
	}
	
}