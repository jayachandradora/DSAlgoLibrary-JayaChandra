package collections;

import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) {

		WeakHashMap<Emp, String> empMap = new WeakHashMap<Emp, String>();
		empMap.put(new Emp("1", "JC"), "1111");
		empMap.put(new Emp("3", "Ishu"), "3333");

		Emp emp2 = new Emp("2", "Sujii");
		empMap.put(emp2, "22222");

		System.out.println("Size of map array " + empMap.size());
		System.gc();
		System.out.println("Size of map array post gc " + empMap.size());
	}
}

class Emp {
	String id;
	String name;

	public Emp(String empId, String empName) {
		id = empId;
		name = empName;
	}
}