package collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentDemo extends Thread {

	// static ArrayList<String> al = new ArrayList<>();
	static CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<>();

	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		al.add("d");
	}

	public static void main(String args[]) throws InterruptedException {

		al.add("A");
		al.add("B");
		al.add("C");

		// We create a child thread that is going to modify CopyOnWriteArraySet l.
		ConcurrentDemo cd = new ConcurrentDemo();
		cd.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("child going to add element");
		}

		System.out.println(al);

		// Now we iterate through the CopyOnWriteArraySet and we wont get exception.
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			String s = (String)itr.next();
            System.out.println(s);
         
            if(s.equals("C"))  // Here we will get RuntimeException
                itr.remove();
		}
		System.out.println(al);
	}

}
