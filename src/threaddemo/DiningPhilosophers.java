package threaddemo;

public class DiningPhilosophers {

	public static void main(String[] args) throws Exception {
		 
        final Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];
 
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }
 
        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
 
            if (i == philosophers.length - 1) {
                 
                // The last philosopher picks up the right fork first
                philosophers[i] = new Philosopher(rightFork, leftFork); 
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }
             
            Thread t 
              = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}

class Philosopher implements Runnable {
	 
    // The forks on either side of this Philosopher 
    private Object leftFork;
    private Object rightFork;
 
    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }
 
    @Override
    public void run() {
        // Yet to populate this method
    }
 // Member variables, standard constructor
    
    private void doAction(String action) throws InterruptedException {
        System.out.println(
          Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }
}