package ds;

import java.util.*;

//FIFO
public class QueueImplement {

	protected int Queue[];
	protected int front, rear, size;

	/* Constructor */
	public QueueImplement(int n) {
		size = n;
		Queue = new int[size];
		front = -1;
		rear = -1;
	}

	/* Function to check if queue is empty */
	public boolean isEmpty() {
		return front == -1;
	}

	/* Function to check if queue is full */
	public boolean isFull() {
		return front == 0 && rear == size - 1;
	}

	/* Function to get the size of the queue */
	public int getSize() {
		return rear;
	}

	/* Function to check the front element of the queue */
	public int peek() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return Queue[front];
	}

	/* Function to insert an element to the queue */
	public void insert(int i) {
		if (rear == -1) {
			front = 0;
			rear = 0;
			Queue[rear] = i;
		} else if (rear + 1 >= size)
			throw new IndexOutOfBoundsException("Overflow Exception");
		else if (rear + 1 < size)
			Queue[++rear] = i;
	}

	/* Function to remove front element from the queue */
	public int remove() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		else {
			int ele = Queue[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			} else
				front++;
			return ele;
		}
	}

	/* Function to display the status of the queue */
	public void display() {
		System.out.print("\nQueue = ");
		if (rear == -1) {
			System.out.print("Empty\n");
			return;
		}
		for (int i = front; i <= rear; i++)
			System.out.print(Queue[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		QueueImplement qiobj = new QueueImplement(5);
		qiobj.insert(10);
		qiobj.insert(11);
		qiobj.insert(12);
		qiobj.insert(13);
		qiobj.insert(14);
		//qiobj.display();
		qiobj.remove();
		//qiobj.display();
		qiobj.insert(14);
		System.out.println("Size of the quey " + qiobj.getSize());
	}

}
