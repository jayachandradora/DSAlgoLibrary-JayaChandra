package threaddemo;

public class TickTickDemo {

	public static void main(String[] args) {

		Msg msg = new Msg("TickTick");
		Waiter1 waiter1 = new Waiter1(msg);
		Waiter1 waiter2 = new Waiter1(msg);
		new Thread(waiter1, "waiter1").start();
		new Thread(waiter2, "waiter2").start();

		Notifier1 ntfr = new Notifier1(msg);
		new Thread(ntfr, "Notfier1").start();
		
	}
}

class OddEven extends Thread{
	
	public void run(){
		
		
	}
}

class Notifier1 implements Runnable {

	Msg msg;
	public Notifier1(Msg msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		System.out.println("Notifire is inprogress " + Thread.currentThread().getName());
		synchronized(msg){
			msg.setMessage("push notification from " + Thread.currentThread().getName());
			msg.notifyAll();
			System.out.println("Notification Over");
		}
	}
}

class Waiter1 implements Runnable {

	Msg msg;

	public Waiter1(Msg msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		System.out.println("Waiter is waiting " + Thread.currentThread().getName());

		synchronized (msg) {
			try {
				msg.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//process the message now
        System.out.println(Thread.currentThread().getName()+" processed: and work done " +  msg.getMessage());
	}
}

class Msg {
	private String message;

	public Msg(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}