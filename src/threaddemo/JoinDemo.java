package threaddemo;

public class JoinDemo implements Runnable {

	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Current Runnable thread:(JoinDemo Execution Completed)  " + t.getName());

		// checks if current thread is alive
		System.out.println("Is Alive? " + t.isAlive());
	}

	public static void main(String args[]) throws Exception {
		Thread t = new Thread(new JoinDemo());
		Thread t1 = new Thread(new JoinThread());
		t.start();
		t1.start();
		t1.join();
		// Waits for 1000ms this thread to die.
		t.join(1000);

		System.out.println("\nJoining after 1000" + " mili seconds: \n");
		System.out.println("Current thread: " + t.getName());

		// Checks if this thread is alive
		System.out.println("Is alive? " + t.isAlive());
	}
}

class JoinThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Join Thread execution completed");
	}

}