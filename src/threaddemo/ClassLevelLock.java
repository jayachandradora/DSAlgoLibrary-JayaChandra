package threaddemo;

//https://www.geeksforgeeks.org/class-level-lock-in-java/
//https://www.tutorialspoint.com/difference-between-object-level-lock-and-class-level-lock-in-java
class ClassLevelLock implements Runnable {

	public void run() {
		Lock();
	}

	// Method is static
	public static synchronized void Lock() {
		System.out.println(Thread.currentThread().getName());
		
		synchronized (ClassLevelLock.class) { // class level lock
			System.out.println("in block " + Thread.currentThread().getName());
			System.out.println("in block " + Thread.currentThread().getName() + " end");
		}
	}

	public static void main(String[] args) {
		ClassLevelLock g1 = new ClassLevelLock();

		Thread t1 = new Thread(g1);

		Thread t2 = new Thread(g1);
		ClassLevelLock g2 = new ClassLevelLock();
		Thread t3 = new Thread(g2);

		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");

		t1.start();
		t2.start();
		t3.start();
	}
}

// JD Free time you wite this video code for object and class level lock... // Above one is confusing with object creation
// https://www.youtube.com/watch?v=UmUbv3Nxz7g&ab_channel=ShankarS