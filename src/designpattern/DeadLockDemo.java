package designpattern;

public class DeadLockDemo {

	String s1 = "JD";
	String s2 = "JD2";
	Thread t1 = new Thread() {
		public void run() {
			while(true) {
				synchronized(s1) {
					System.out.println("s1 executed inside s2 Locked");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (s2) {
						System.out.println("s1 executed inside s2");
					}
				}
			}
		}
	};

	Thread t2 = new Thread() {
		public void run() {
			while(true) {
				synchronized(s2) {
					System.out.println("s2 executed inside s1 Loked");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (s1) {
						System.out.println("s2 executed inside s1");
					}
				}
			}
		}
	};
	public static void main(String args[]) {
		DeadLockDemo dd = new DeadLockDemo();
		//new TC(dd).start();
		//new TC1(dd).start();
		
		// Another example of deadlock
		dd.t1.start();
		dd.t2.start();
	}
	
	/* * This method request two locks, first String and then Integer */
	public void method1() {
		synchronized (String.class) {
			System.out.println("Aquired lock on String.class object");
			synchronized (Integer.class) {
				System.out.println("Aquired lock on Integer.class object");
			}
		}
	}

	public void method2() {
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println("Aquired lock on String.class object");
			}
		}
	}
}

class TC extends Thread {
	DeadLockDemo msg;

	public TC(DeadLockDemo msg) {
		this.msg = msg;
	}

	public void run() {
		msg.method1();
	}
}

class TC1 extends Thread {
	DeadLockDemo msg;

	public TC1(DeadLockDemo msg) {
		this.msg = msg;
	}

	public void run() {
		msg.method2();
	}
}