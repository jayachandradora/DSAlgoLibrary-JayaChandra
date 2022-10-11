package threaddemo;

//https://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example
public class NotifyAndNotifyAllDemo {

	public static void main(String[] args) {
		Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();
        
        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();
        
        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
	}
}
class Notifier implements Runnable{

	private Message message;
	Notifier(Message msg) {
		this.message = msg;
	}
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(1000);
            synchronized (message) {
            	message.setMessage(name+" Notifier work done");
            	//message.notify();
            	message.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
class Waiter implements Runnable {

	private Message message;
	Waiter(Message msg) {
		this.message = msg;
	}
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		synchronized(message){
			try{
				System.out.println(threadName+
						" waiting to get notified at time:"+System.currentTimeMillis());
				message.wait();
			}catch (InterruptedException ex){
				ex.printStackTrace();
			}
			System.out.println(threadName+" waiter thread got notified at time:"
					+System.currentTimeMillis());
            //process the message now
            System.out.println(threadName+" processed: "+message.getMessage());
		}
	}
}

class Message {

	private String message;
	Message(String msg) {
		message = msg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}