package designpattern;

import java.lang.reflect.Constructor;

public class SingleTonViolatesThruReflection {
	
	private static SingleTonViolatesThruReflection stvr = new SingleTonViolatesThruReflection();
	private SingleTonViolatesThruReflection(){
		System.out.println("Creating ......");
	}

	public static SingleTonViolatesThruReflection getInstances(){
		return stvr;
	}


	public static void main(String args[])throws Exception{
		
		SingleTonViolatesThruReflection st1 = SingleTonViolatesThruReflection.getInstances();
		SingleTonViolatesThruReflection st2 = SingleTonViolatesThruReflection.getInstances();
		
		SingleTonViolatesThruReflection.print("st1", st1);
		SingleTonViolatesThruReflection.print("st2", st2);

		//Violate Single ton through Reflection

		Class clazz = Class.forName("designpattern.SingleTonViolatesThruReflection");
		Constructor<SingleTonViolatesThruReflection> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		SingleTonViolatesThruReflection st3 = constructor.newInstance();
		SingleTonViolatesThruReflection.print("st3", st3);
	}
	
	static void print(String name, Object obj){
		System.out.println("Name " + name + " object hash code " + obj.hashCode());
	}
}
