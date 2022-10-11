package javademo;

public class JavaChaining {

	static {
		System.out.println("5");
	}
	static {
		System.out.println("default");
	}

	public JavaChaining() {
		System.out.println("JavaChaining no parameter");
		{
			System.out.println("||||||||");
		}
	}

	public JavaChaining(int x, int y) {
		System.out.println("sadfasdfsa");
		{
			System.out.println(":::::::");
		}
	}

	public static void main(String[] args) {
		// new JavaChaining(5, 4);
		new JavaChaining();
	}

	{
		System.out.println("step1");
	}
	{
		System.out.println("step2");
	}
	{
		System.out.println("step3");
	}

}
