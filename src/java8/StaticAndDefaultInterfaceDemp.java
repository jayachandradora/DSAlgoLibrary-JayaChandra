package java8;

public class StaticAndDefaultInterfaceDemp implements I {

	public static void main(String[] args) {
		I.disp();// static method of interface directly we can call
		new StaticAndDefaultInterfaceDemp().show();// default methods we can call like this through object
	}

}

interface I{
	
	default void show(){
		System.out.println("show");
	}
	
	static void disp(){
		System.out.println("disp");
	}
}