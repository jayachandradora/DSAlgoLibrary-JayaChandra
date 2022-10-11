package threaddemo;

public class RunThreadSequentialT1T2T3 {

	public static void main(String[] args) {

		final Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("T1");
			}
		});

		final Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					t1.join(2000);
				} catch (Exception e) {
					e.getStackTrace();
				}
				System.out.println("T2");
			}
		});

		final Thread t3 = new Thread(new Runnable() {
			public void run() {

				try {
					t2.join(4000);
				} catch (Exception e) {
					e.getStackTrace();
				}
				System.out.println("T3");
			}
		});
		// we are reversing the order of the start() method
		t3.start();
		t2.start();
		t1.start();

		test();
	}

	static void test() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("T1111111");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("T22222222");
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("T3333333");
			}
		});

		// Test here
		try {
			t1.start();
			t2.join();
			if (!t1.isAlive())
				t2.start();

			t2.join();

			if (!t2.isAlive())
				t3.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
