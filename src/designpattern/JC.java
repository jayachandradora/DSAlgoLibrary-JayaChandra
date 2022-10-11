package designpattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JC {

	public static void main(String[] args) {
		ExecutorService exSer = Executors.newFixedThreadPool(2);
		exSer.submit(JC :: getInstance);
		exSer.submit(JC :: getInstance);
		exSer.shutdown();
		
		System.out.println("Single Instance " + getInstance().hashCode());
		System.out.println("Single Instance1 " + getInstance().hashCode());
		System.out.println("Single Instance2 " + getInstance().hashCode());
	}
	
	public static void disp() {
		System.out.println("JD");
	}
	
	private JC() {}
	private static JC getInstance = null;
	
	public static synchronized JC getInstance() {
		if(getInstance == null)
			return new JC();
		
		return getInstance;
	}
}
