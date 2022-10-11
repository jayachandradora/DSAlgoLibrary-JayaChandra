package threaddemo;

import java.util.LinkedList;
import java.util.Queue;

public class InterThreadCommunicationExample {

    public static void main(String args[]) {

        final Queue sharedQ = new LinkedList();

        Thread producer = new Producer1(sharedQ);
        Thread consumer = new Consumer1(sharedQ);

        producer.start();
        consumer.start();

    }
}

class Producer1 extends Thread {
    private final Queue sharedQ;

    public Producer1(Queue sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {

        for (int i = 0; i < 4; i++) {
            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() >= 1) {
                    try {
                        System.out.println("Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("producing : " + i);
                sharedQ.add(i);
                sharedQ.notify();
            }
        }
    }
}

class Consumer1 extends Thread {
    private final Queue sharedQ;

    public Consumer1(Queue sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while(true) {

            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() == 0) {
                    try {
                    	System.out.println("Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                int number = (int) sharedQ.poll();
                sharedQ.notify();
              
                //termination condition
                if(number == 3){break; }
            }
        }
    }
}


