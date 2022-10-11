package designpattern;

import java.io.Serializable;

public class SingleTonEnum {

	public static void main(String[] args) {
		SingleTonEnumClass singleTon = SingleTonEnumClass.INSTACE;
		System.out.println(singleTon.getValue());
		singleTon.setValue(5);
		System.out.println(singleTon.getValue());
	}

}

class SingleTon implements Serializable{
	private static final long serialVersionUID = 4383178481677064761L;
	
	private static final SingleTon instance = new SingleTon();
	private SingleTon(){};
	public static SingleTon getInstance(){
		return instance;
	}
}
class SyncSingleTon {
	private static  SyncSingleTon instance;
	private static Object mutex = new Object();

	private SyncSingleTon() {
	}

	public static SyncSingleTon getInstance() {
		if (instance == null) {
			synchronized (SyncSingleTon.class /** OR mutex*/) {
				if (instance == null) {
					instance = new SyncSingleTon();
				}
			}
		}
		return instance;
	}
}

// Since enums are inherently serializable.,
// we don't need to implement it with a serializable interface.
// The reflection problem is also not there. Therefore,
// it is 100% guaranteed that only one instance of the singleton is present
// within a JVM.
// Thus, this method is recommended as the best method of making singletons in
// Java.
enum SingleTonEnumClass{
	INSTACE;

	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}