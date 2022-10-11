package designpattern;

//Java code to remove the effect of 
//Serialization on singleton classes
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SingletonReadResolve implements Serializable {
	// public instance initialized when loading the class
	public static SingletonReadResolve instance = new SingletonReadResolve();

	private SingletonReadResolve() {
		// private constructor
	}

	// implement readResolve method
	protected Object readResolve() {
		return instance;
	}
}

public class SingletonSerializableDemo {
	public static void main(String[] args) {
		try {
			SingletonReadResolve instance1 = SingletonReadResolve.instance;
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
			out.writeObject(instance1);
			out.close();

			// deserailize from file to object
			ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
			SingletonReadResolve instance2 = (SingletonReadResolve) in.readObject();
			in.close();

			System.out.println("instance1 hashCode:- " + instance1.hashCode());
			System.out.println("instance2 hashCode:- " + instance2.hashCode());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


