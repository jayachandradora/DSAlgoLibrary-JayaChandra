package ds;

public class IntQ {

	int intQ[];
	int total;
	int front;
	int rear;
	int size;

	public IntQ() {
		total = 0;
		front = 0;
		rear = 0;
		size = 20;
		intQ = new int[size];
	}

	public boolean isFull() {
		if (size == total)
			return true;
		else
			return false;
	}

	public boolean enQueue(int item) {
		if (isFull()) {
			return false;
		} else {
			total++;
			intQ[rear] = item;
			rear++;
			return true;
		}
	}

	public int deQueue() {
		int item = intQ[front];
		front++;
		total--;
		return item;
	}
	
	public static void main(String[] args) {
		IntQ intq = new IntQ();
		intq.enQueue(1);
		intq.enQueue(2);
		intq.enQueue(3);
		intq.enQueue(4);
		
		System.out.println("Print dequed item " + intq.deQueue());
		System.out.println("Print dequed item " + intq.deQueue());
	}

}
