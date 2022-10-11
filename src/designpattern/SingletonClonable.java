package designpattern;

//JAVA code to explain overcome 
//cloning issue with singleton
class SuperClass implements Cloneable {
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

// Singleton class
class SingletonClass extends SuperClass {
	// public instance initialized when loading the class
	public static SingletonClass instance = new SingletonClass();

	private SingletonClass() {
		// private constructor
	}

	// JC this method comment it and see how it creates different object
	// To overcome this issue, override clone() method and
	// throw an exception from clone method that is CloneNotSupportedException
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}

public class SingletonClonable {
	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonClass instance1 = SingletonClass.instance;
		SingletonClass instance2 = (SingletonClass) instance1.clone();
		System.out.println("instance1 hashCode:- " + instance1.hashCode());
		System.out.println("instance2 hashCode:- " + instance2.hashCode());
	}
}
