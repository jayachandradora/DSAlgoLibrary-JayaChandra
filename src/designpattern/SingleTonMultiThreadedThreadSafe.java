package designpattern;

//https://dzone.com/articles/demystifying-volatile-and-synchronized-again
public class SingleTonMultiThreadedThreadSafe {

	private static volatile SingleTonMultiThreadedThreadSafe INSTANCE;
	private static final Object mutex = new Object();
	private volatile boolean someFlag;
	private volatile int counter;

	// more mutable state on this singleton
	private SingleTonMultiThreadedThreadSafe(boolean someFlag) {
		this.someFlag = someFlag;
	}

	public static SingleTonMultiThreadedThreadSafe getInstance() {
		SingleTonMultiThreadedThreadSafe singleton = INSTANCE;
		if (singleton != null)
			return singleton;
		
		synchronized (mutex) {
			if (INSTANCE == null)
				INSTANCE = new SingleTonMultiThreadedThreadSafe(false);
			return INSTANCE;
		}
	}

	public boolean isSomeFlag() {
		return someFlag;
	}

	public void setSomeFlag(boolean someFlag) {
		this.someFlag = someFlag;
	}

	public int getCounter() {
		return counter;
	}

	public synchronized void incrementCounter() {
		counter++;
	}

}
