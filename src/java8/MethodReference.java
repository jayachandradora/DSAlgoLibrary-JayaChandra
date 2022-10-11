package java8;

interface Sayable{
	void say();
}
public class MethodReference {
	public static int saySomething(){
		System.out.println("Hello, this is static method.");
		return 1;
	}
	public static void main(String[] args) {
	    // Referring static method
	    Sayable sayable = MethodReference::saySomething;
	    // Calling interface method
	    sayable.say();
	    
	}
}