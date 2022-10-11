package threaddemo;

public class JoinExample extends Thread {
	public void run() {
		System.out.println("geeks " + Thread.currentThread().getName());
		try {
			Thread.sleep(300);
		} catch (InterruptedException ie) {
		}
		System.out.println("forgeeks " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		JoinExample c1 = new JoinExample();
		JoinExample c2 = new JoinExample();
		c1.setName("1");
		c1.start();
		c2.setName("2");
		try {
			c1.join(); // Waiting for c1 to finish
		} catch (InterruptedException ie) {
		}
		c2.start();
	}
}