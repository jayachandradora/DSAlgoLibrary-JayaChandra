package designpattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class CountMinSketch {
	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Character> blockingQueue = new LinkedBlockingQueue<>();

		Thread producer = new Thread(new ProducerTask(blockingQueue));
		Thread consumer = new Thread(new ConsumerTask(blockingQueue));

		producer.start();
		consumer.start();

		producer.join();
		consumer.join();
	}
}

class ProducerTask implements Runnable {

	BlockingQueue<Character> blockingQueue;

	public static Character[] alphabets = new Character[26];

	static {
		for (int i = 0; i < 26; i++) {
			alphabets[i] = (char) ('A' + i);
		}
		System.out.println("Alphabets array : " + alphabets);
	}

	public ProducerTask(final BlockingQueue<Character> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		while (true) {
			final int randomNumber = ThreadLocalRandom.current().nextInt(26);
			blockingQueue.add(alphabets[randomNumber]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ConsumerTask implements Runnable {

	private static final int H1 = 0;
	private static final int H2 = 1;
	private static final int H3 = 2;
	private static final int H4 = 3;

	final static int LIMIT = 100;
	final int[][] sketch = new int[4][LIMIT];

	final HashFunction h1 = new HashFunction(11, 9);
	final HashFunction h2 = new HashFunction(17, 15);
	final HashFunction h3 = new HashFunction(31, 29);
	final HashFunction h4 = new HashFunction(61, 59);

	BlockingQueue<Character> blockingQueue;
	final int[] actualFrequency = new int[26];

	public ConsumerTask(final BlockingQueue<Character> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		while (true) {
			Character alphabet = 'A';
			try {
				alphabet = blockingQueue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			actualFrequency[alphabet - 'A']++;

			sketch[H1][h1.getHashValue(alphabet)]++;
			sketch[H2][h2.getHashValue(alphabet)]++;
			sketch[H3][h3.getHashValue(alphabet)]++;
			sketch[H4][h4.getHashValue(alphabet)]++;

			System.out.println("--------------------------------------------------------------------------");

			System.out.println("Actual Frequency of " + alphabet + " : " + actualFrequency[alphabet - 'A']);
			System.out.println("Count Min Sketch of " + alphabet + " : "
					+ findMinimum(sketch[H1][h1.getHashValue(alphabet)], sketch[H2][h2.getHashValue(alphabet)],
							sketch[H3][h3.getHashValue(alphabet)], sketch[H4][h4.getHashValue(alphabet)]));
		}
	}

	private int findMinimum(final int a, final int b, final int c, final int d) {
		return Math.min(Math.min(a, b), Math.min(c, d));
	}

	private static class HashFunction {

		private long prime;
		private long odd;

		public HashFunction(final long prime, final long odd) {
			this.prime = prime;
			this.odd = odd;
		}

		public int getHashValue(final Character character) {
			int hash = character.hashCode();
			if (hash < 0) {
				hash = Math.abs(hash);
			}
			return calculateHash(hash, prime, odd);
		}

		private int calculateHash(final int hash, final long prime, final long odd) {
			return (int) ((((hash % LIMIT) * prime) % LIMIT) * odd) % LIMIT;
		}

	}
}