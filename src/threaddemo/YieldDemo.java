package threaddemo;

//MyThread extending Thread
class MyThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++)
			System.out.println(Thread.currentThread().getName() + " in control");
	}
}

public class YieldDemo {

	public static void main(String[] args) {
		MyThread1 t = new MyThread1();
		t.start();

	
		for (int i = 0; i < 5; i++) {
			// Control passes to child thread ---JC Point this line for interview
			//always pausing its execution and giving chance to child thread(with same priority).
			Thread.yield();
			//The thread which executes the yield method 
			//will enter in the Runnable state from Running state.
			// After execution of child Thread
			// main thread takes over
			System.out.println(Thread.currentThread().getName() + " in control");
		}
	}
}
