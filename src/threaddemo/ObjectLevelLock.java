package threaddemo;

//https://www.geeksforgeeks.org/object-level-lock-in-java/
class ObjectLevelLock implements Runnable {

	public void run() {
		Lock();
	}

	// Synchronization of non-static methods (object lock) as different synchronized
	// non-static methods are called in both threads

	// Then both threads need to acquire the object lock After one is acquired, the other thread must wait
	// for one thread to finish the executing before the other thread starts to execute.
	public void Lock() {
		System.out.println(Thread.currentThread().getName());
		synchronized (this) {
			System.out.println("in block " + Thread.currentThread().getName());
			System.out.println("in block " + Thread.currentThread().getName() + " end");
		}
	}

	public static void main(String[] args) {
		// Creating an object of above class in the main() method
		ObjectLevelLock g = new ObjectLevelLock();
		Thread t1 = new Thread(g);
		Thread t2 = new Thread(g);

		// Creating another object of above class
		ObjectLevelLock g1 = new ObjectLevelLock();
		Thread t3 = new Thread(g1);

		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");

		t1.start();
		t2.start();
		t3.start();
	}
}