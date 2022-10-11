package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizationArrayList {
	public static void main(String[] args) {
		List<String> list = Collections.synchronizedList(new ArrayList<String>());

		list.add("practice");
		list.add("code");
		list.add("quiz");

		synchronized (list) {
			Iterator it = list.iterator();

			while (it.hasNext())
				System.out.println(it.next());
		}
	}
}
