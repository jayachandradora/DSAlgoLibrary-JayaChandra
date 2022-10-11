package systemdesign;


//https://www.youtube.com/watch?v=lqtl1DBLSzA
//Thread-1(1)	Thread-2(2)	Thread-3(0)  // All ways see what is the reminder of a number ..that will be the number
//	1				2			3
//	4				5			6
//	7				8			9
//	10  // all these numbers divisible by 3 and its reminder will be thread number ex .. 7%3 = 1(thread1), 8%3 = 2(thread 2), 6%3 = 3
public class SequenceNumberGeneratorTest {
	private static final int TOTAL_NUMBER_IN_SEQUENCE = 20;
	private static final int TOTAL_NUMBER_OF_THREADS = 3;

	public static void main(String[] args) {

		NumbersGenerator numbersGenerator = new NumbersGenerator(TOTAL_NUMBER_OF_THREADS, TOTAL_NUMBER_IN_SEQUENCE);

		// Created three Threads
		Thread t1 = new Thread(new SequenceGeneratorTask(numbersGenerator, 1), "Thread-1");
		Thread t2 = new Thread(new SequenceGeneratorTask(numbersGenerator, 2), "Thread-2");
		Thread t3 = new Thread(new SequenceGeneratorTask(numbersGenerator, 0), "Thread-3");

		// Start all three threads
		t1.start();
		t2.start();
		t3.start();
	}
}

class SequenceGeneratorTask implements Runnable {

	private NumbersGenerator numbersGenerator;
	private int result;

	public SequenceGeneratorTask(NumbersGenerator numbersGenerator, int result) {
		super();
		this.numbersGenerator = numbersGenerator;
		this.result = result;
	}

	@Override
	public void run() {
		numbersGenerator.printNumbers(result);
	}
}

class NumbersGenerator {

	private int number = 1;
	private int numberOfThreads;
	private int totalNumbersInSequence;

	public NumbersGenerator(int numberOfThreads, int totalNumbersInSequence) {
		super();
		this.numberOfThreads = numberOfThreads;
		this.totalNumbersInSequence = totalNumbersInSequence;
	}

	public void printNumbers(int result) {
		synchronized (this) {
			while (number < totalNumbersInSequence - 1) {
				while (number % numberOfThreads != result) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println(Thread.currentThread().getName() + " " + number++);
				notifyAll();
			}
		}
	}
}