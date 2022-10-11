package systemdesign;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


//https://www.youtube.com/watch?v=tTNrG7gAxks

/*
 * CyclicBarrier is that different threads hang tight for one another(wait for each other)and when all have finished their execution, 
 * the result needs to be combined in the parent thread.
 */
public class CyclicBarrierExample {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName() + " has started...");
		CyclicBarrier barrier = new CyclicBarrier(4);

		PassengerThread p1 = new PassengerThread(1000, barrier, "JD");
		PassengerThread p2 = new PassengerThread(1000, barrier, "John");
		PassengerThread p3 = new PassengerThread(1000, barrier, "Sujii");
		PassengerThread p4 = new PassengerThread(1000, barrier, "Shyam");
		
		PassengerThread p5 = new PassengerThread(2000, barrier, "Rajib");
		PassengerThread p6 = new PassengerThread(2000, barrier, "Laxmi");
		PassengerThread p7 = new PassengerThread(2000, barrier, "Mahi");
		PassengerThread p8 = new PassengerThread(2000, barrier, "Ishani");
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		p5.start();
		p6.start();
		p7.start();
		p8.start();
		
		System.out.println(Thread.currentThread().getName() + " has Ended");
	}

}

class PassengerThread extends Thread {

	int duration;
	CyclicBarrier barrier;

	public PassengerThread(int duration, CyclicBarrier barrier, String pName) {
		super(pName);
		this.duration = duration;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName() + " is arrived...");

			int await = barrier.await();
			
			if(await == 0)
				System.out.println("Four passanger has arrived, So cab is going to start...");
		} catch (BrokenBarrierException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}