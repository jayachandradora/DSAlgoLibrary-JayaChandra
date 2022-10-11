package string;

public class Demo extends B{

	private void disp(){
		System.out.println("disp B");
	}
	public static void main(String[] args) {
		B.show();
		new Demo().disp();
		A a = new B();
		a.show();
	}

}

class A {
	public static void show(){
		System.out.println("Show A ");
	}
	
	private void disp(){
		System.out.println("disp a");
	}
}

class B extends A{
	public static void show(){
		System.out.println("Show B ");
	}
	private void disp(){
		System.out.println("disp B");
	}
}