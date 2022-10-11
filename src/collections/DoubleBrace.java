package collections;

//Java program to demonstrate working of Double
//Brace Initialization
import java.util.HashSet;
import java.util.Set;

public class DoubleBrace {
	public static void main(String[] args) {
		Set<String> sets = new HashSet<String>() {
			{
				add("one");
				add("two");
				add("three");
			}
		};

		// ...

		// Now pass above collection as parameter to method
		useInSomeMethod(sets);
	}

	private static void useInSomeMethod(Set<String> sets) {
		System.out.println(sets);
	}
}