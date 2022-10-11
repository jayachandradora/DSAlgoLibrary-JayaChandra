package systemdesign;

import java.util.concurrent.Semaphore;

public class OddEvenPrintWithSemaphore {

	public static void main(String[] args) {

		int TOTAL_NUMBER_IN_SEQUENCE = 20;

		OddAndEvenNumberGenerator oddAndEvenNumberGenerator = new OddAndEvenNumberGenerator();
		OddNumberGenerator oddNumberGenerator = new OddNumberGenerator(oddAndEvenNumberGenerator,
				TOTAL_NUMBER_IN_SEQUENCE);
		EvenNumberGenerator evenNumberGenerator = new EvenNumberGenerator(oddAndEvenNumberGenerator,
				TOTAL_NUMBER_IN_SEQUENCE);

		Thread t1 = new Thread(oddNumberGenerator, "Thread-1");
		Thread t2 = new Thread(evenNumberGenerator, "Thread-2");

		t1.start();
		t2.start();
	}
}

class EvenNumberGenerator implements Runnable {

	private OddAndEvenNumberGenerator oddAndEvenNumberGenerator;
	private int totalNumberInSEquence;

	public EvenNumberGenerator(OddAndEvenNumberGenerator oddAndEvenNumberGenerator, int totalNumberInSEquence) {
		super();
		this.oddAndEvenNumberGenerator = oddAndEvenNumberGenerator;
		this.totalNumberInSEquence = totalNumberInSEquence;
	}

	@Override
	public void run() {
		for (int i = 2; i <= totalNumberInSEquence; i = i + 2) {
			oddAndEvenNumberGenerator.printEvenNumber(i);
		}
	}
}

class OddNumberGenerator implements Runnable {

	private OddAndEvenNumberGenerator oddAndEvenNumberGenerator;
	private int totalNumberInSEquence;

	public OddNumberGenerator(OddAndEvenNumberGenerator oddAndEvenNumberGenerator, int totalNumberInSEquence) {
		super();
		this.oddAndEvenNumberGenerator = oddAndEvenNumberGenerator;
		this.totalNumberInSEquence = totalNumberInSEquence;
	}

	@Override
	public void run() {
		for (int i = 1; i <= totalNumberInSEquence; i = i + 2) {
			oddAndEvenNumberGenerator.printOddNumber(i);
		}
	}
}

class OddAndEvenNumberGenerator {

	private Semaphore semaphoreOdd = new Semaphore(1);
	private Semaphore semaphoreEven = new Semaphore(0);

	public void printOddNumber(int number) {
		try {
			semaphoreOdd.acquire();
			System.out.println(Thread.currentThread().getName() + ":" + number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphoreEven.release();
		}
	}

	public void printEvenNumber(int number) {
		try {
			semaphoreEven.acquire();
			System.out.println(Thread.currentThread().getName() + ":" + number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphoreOdd.release();
		}
	}
}
