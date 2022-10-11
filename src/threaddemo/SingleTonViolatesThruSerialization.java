package threaddemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingleTonViolatesThruSerialization implements Serializable{
	
	private static SingleTonViolatesThruSerialization stvr = new SingleTonViolatesThruSerialization();
	private SingleTonViolatesThruSerialization(){
		System.out.println("Creating ......");
	}

	public static SingleTonViolatesThruSerialization getInstances(){
		return stvr;
	}


	public static void main(String args[])throws Exception{
		
		SingleTonViolatesThruSerialization st1 = SingleTonViolatesThruSerialization.getInstances();
		SingleTonViolatesThruSerialization st2 = SingleTonViolatesThruSerialization.getInstances();
		
		SingleTonViolatesThruSerialization.print("st1", st1);
		SingleTonViolatesThruSerialization.print("st2", st2);

		//Violate Single ton through Serialization
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/jdora/Downloads/singleton.txt"));
		oos.writeObject(st1);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/jdora/Downloads/singleton.txt"));
		SingleTonViolatesThruSerialization st3 = (SingleTonViolatesThruSerialization)ois.readObject();
		
		SingleTonViolatesThruSerialization.print("st3", st3);
	}
	
	static void print(String name, Object obj){
		System.out.println("Name " + name + " object hash code " + obj.hashCode());
	}
}
