package systemdesign;

import java.util.concurrent.CountDownLatch;

// 	https://www.youtube.com/watch?v=59oQfkdn5mA&ab_channel=KKJavaTutorials

// Its used when a thread needs to wait for other threads before starting its work.
public class CountDownLatchExample {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(2);
		DevTeam teamA = new DevTeam(countDownLatch, "DevTeamA");
		DevTeam teamB = new DevTeam(countDownLatch, "DevTeamB");

		teamA.start();
		teamB.start();
		
		countDownLatch.await();// Wait upto two task has completed.
		
		QATeam qaTeam = new QATeam("QA Team");
		qaTeam.start();
	}

}

class DevTeam extends Thread{
	CountDownLatch countDownLatch = null;
	
	DevTeam(CountDownLatch cdLatch, String name){
		super(name);
		this.countDownLatch = cdLatch; 
	}
	
	@Override
	public void run() {
		System.out.println("Task has assigned to Dev team " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Task Completed by Dev Team " + Thread.currentThread().getName());
		countDownLatch.countDown();
	}
}

class QATeam extends Thread{
	
	QATeam(String str){
		super(str);
	}
	
	@Override
	public void run() {
		
		System.out.println("QA Team task has been started " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task has been completed " + Thread.currentThread().getName());
		
	}
}
