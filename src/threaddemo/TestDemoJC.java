package threaddemo;

interface A {
	static void disp() {
		System.out.println("Disp");
	}

	default void show() {
		System.out.println("A");
	}
}

interface B {
	/*default boolean equals(Object o){
		return true;
	}*/
	default void show() {
		System.out.println("B");
	}
}

class C {
	public void show() {
		System.out.println("C");
	}
}

public class TestDemoJC extends C implements A, B {

	public static void main(String[] args) {
		A.disp();
	}

}
