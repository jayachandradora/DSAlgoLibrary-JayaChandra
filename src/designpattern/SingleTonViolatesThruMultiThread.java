package designpattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTonViolatesThruMultiThread {

	private static SingleTonViolatesThruMultiThread stvr = null;

	private SingleTonViolatesThruMultiThread() {
		System.out.println("Creating ......");
	}

	public static SingleTonViolatesThruMultiThread getInstances() {
		if (stvr == null) 
			stvr = new SingleTonViolatesThruMultiThread();
		
		return stvr;
	}

	public static SingleTonViolatesThruMultiThread getInstance() {
		if (stvr != null)
			return stvr;

		synchronized (SingleTonViolatesThruMultiThread.class) {
			if (stvr == null)
				stvr = new SingleTonViolatesThruMultiThread();
		}

		return stvr;
	}

	static void useSingleTon() {
		SingleTonViolatesThruMultiThread stvt = SingleTonViolatesThruMultiThread.getInstances();
		SingleTonViolatesThruMultiThread.print("SingleTon Obj", stvt);
	}

	public static void main(String args[]) throws Exception {

		ExecutorService exSer = Executors.newFixedThreadPool(4);
		for (int i = 0; i <= 10; i++) {
			exSer.submit(SingleTonViolatesThruMultiThread::useSingleTon);
		}
		exSer.shutdown();
	}

	static void print(String name, Object obj) {
		System.out.println("Name " + name + " object hash code " + obj.hashCode());
	}
}
