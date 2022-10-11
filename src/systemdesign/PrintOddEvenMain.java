package systemdesign;

public class PrintOddEvenMain {
	
	public static void main(String[] args) {
		
		OddEvenRunnable1 oddRunnable = new OddEvenRunnable1(1);
		OddEvenRunnable1 evenRunnable = new OddEvenRunnable1(0);

		Thread t1 = new Thread(oddRunnable, "Odd");
		Thread t2 = new Thread(evenRunnable, "Even");

		t1.start();
		t2.start();
	}
}

class OddEvenRunnable1 implements Runnable {

	public int PRINT_NUMBERS_UPTO = 20;
	static int number = 1;
	int remainder;
	static Object lock = new Object();

	OddEvenRunnable1(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO) {
			synchronized (lock) {
				if (number % 2 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}
}