package designpattern;

//Java code to explain effect of Reflection
//on Singleton property
//https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/
//
import java.lang.reflect.Constructor;

//https://www.youtube.com/watch?v=QsBQnFUx388&t=400s
class SingletonReflection {
	// public instance initialized when loading the class
	public static SingletonReflection instance = new SingletonReflection();

	private SingletonReflection() {
		// private constructor
	}
}

public class SingletonReflectionDemo {
	public static void main(String[] args) {
		SingletonReflection instance1 = SingletonReflection.instance;
		SingletonReflection instance2 = null;
		try {
			Constructor[] constructors = SingletonReflection.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instance2 = (SingletonReflection) constructor.newInstance();
				break;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("instance1.hashCode():- " + instance1.hashCode());
		System.out.println("instance2.hashCode():- " + instance2.hashCode());
	}
}

/**
Overcome reflection issue: To overcome issue raised by reflection, 
enums are used because java ensures internally that
enum value is instantiated only once. Since java Enums are globally accessible,
they can be used for singletons. Its only drawback is that it is not flexible i.e
it does not allow lazy initialization.

//Java program for Enum type singleton
public enum GFG 
{
INSTANCE;
}
*/