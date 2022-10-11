package collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyDemo {

	public static void main(String[] args) throws InterruptedException {
		CopyOnWriteArrayList l = new CopyOnWriteArrayList();
		l.add("A");
		l.add("B");
		l.add("C");
		Iterator itr = l.iterator();

		while (itr.hasNext()) {
			String s = (String) itr.next();
			System.out.println(s);

			if (s.equals("B")) {
				// Throws RuntimeException
				itr.remove();
			}
			Thread.sleep(1000);
		}
		System.out.println(l);
	}
}
