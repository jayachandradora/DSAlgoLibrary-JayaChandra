package collections;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo extends Thread {

	static ConcurrentHashMap<String, String> al = new ConcurrentHashMap<>();

	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		al.put("d", "Dora");
	}

	public static void main(String args[]) throws InterruptedException {

		al.put("A", "AA");
		al.put("B", "AA");
		al.put("C", "CC");

		// We create a child thread
		// that is going to modify
		// CopyOnWriteArraySet l.
		ConcurrentDemo cd = new ConcurrentDemo();
		cd.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("child going to add element");
		}

		System.out.println(al);

		// Now we iterate through the
		// CopyOnWriteArraySet and we
		// wont get exception.
		Iterator<String> itr = al.keySet().iterator();
		while (itr.hasNext()) {
			String s = (String) itr.next();
			System.out.println(s);

			if (s.equals("C")) {
				System.out.println("print " + s);
				// Here we will not get RuntimeException in CuncurrentHashMap,
				// but we will get Unsupported exception for
				// CopyOnWriteArraylist
				itr.remove();
			}
		}
		System.out.println(al);
	}

}
