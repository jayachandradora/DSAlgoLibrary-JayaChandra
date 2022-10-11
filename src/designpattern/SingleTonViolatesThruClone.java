package designpattern;

//https://www.youtube.com/watch?v=QsBQnFUx388&t=400s
public class SingleTonViolatesThruClone implements Cloneable{
	
	private static SingleTonViolatesThruClone stvr = new SingleTonViolatesThruClone();//eaggerly created instance
	private SingleTonViolatesThruClone(){
		System.out.println("Creating ......");
	}

	public static SingleTonViolatesThruClone getInstances(){
		return stvr;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public static void main(String args[])throws Exception{
		
		SingleTonViolatesThruClone st1 = SingleTonViolatesThruClone.getInstances();
		SingleTonViolatesThruClone st2 = SingleTonViolatesThruClone.getInstances();
		
		SingleTonViolatesThruClone.print("st1", st1);
		SingleTonViolatesThruClone.print("st2", st2);

		//Violate Single ton through Clone
		
		SingleTonViolatesThruClone st3 = (SingleTonViolatesThruClone) st1.clone();
		SingleTonViolatesThruClone.print("St3", st3);
	}
	
	static void print(String name, Object obj){
		System.out.println("Name " + name + " object hash code violated " + obj.hashCode());
	}
}
