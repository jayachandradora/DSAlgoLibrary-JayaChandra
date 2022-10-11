package intv.memoryleak;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class MemoryLeakTest {

	public static void main(String[] args) {
		Vector v = new Vector(214444);
		Vector v1 = new Vector(214744444);
		Vector v2 = new Vector(214444);
		System.out.println("Memory Leaks");

		Map<String, String> map = new HashMap<>(10000);

		try {
			Map<Object, Object> map1 = System.getProperties();
			for (;;) {
				map1.put(new MemLeak("key"), "value");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
