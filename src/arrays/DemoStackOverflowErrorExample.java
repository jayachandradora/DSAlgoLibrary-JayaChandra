package arrays;

public class DemoStackOverflowErrorExample {

	public static void main(String[] args) throws Exception {
		System.out.println("stated");
		try {
			throw new StackOverflowError("hello Stack Overflow");
		} catch (Throwable ex) {
			System.out.println("Exception" + ex.getMessage());
		} finally {
			System.out.println("Finally block");
		}

		"cactus".chars().forEach(c -> System.out.println((char)c));

	    "cactus".chars().parallel().forEach(c -> System.out.print((char)c));

	}
}