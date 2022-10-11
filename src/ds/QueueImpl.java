package ds;

public class QueueImpl {

	private int capacity;
	int queueArr[];
	int front = 0;
	int rear = -1;
	int currentSize = 0;

	public QueueImpl(int queueSize) {
		this.capacity = queueSize;
		queueArr = new int[this.capacity];
	}

	/**
	 * this method adds element at the end of the queue.
	 * 
	 * @param item
	 */
	public void enqueue(int item) {
		if (isQueueFull()) {
			System.out.println("Overflow ! Unable to add element: " + item);
		} else {
			rear++;
			if (rear == capacity - 1) {
				rear = 0;
			}
			queueArr[rear] = item;
			currentSize++;
			System.out.println("Element " + item + " is pushed to Queue !");
		}
	}

	/**
	 * this method removes an element from the top of the queue
	 */
	public void dequeue() {
		if (isQueueEmpty()) {
			System.out.println("Underflow ! Unable to remove element from Queue");
		} else {
			front++;
			if (front == capacity - 1) {
				System.out.println("Pop operation done ! removed: " + queueArr[front - 1]);
				front = 0;
			} else {
				System.out.println("Pop operation done ! removed: " + queueArr[front - 1]);
			}
			currentSize--;
		}
	}

	/**
	 * This method checks whether the queue is full or not
	 * 
	 * @return boolean
	 */
	public boolean isQueueFull() {
		boolean status = false;
		if (currentSize == capacity) {
			status = true;
		}
		return status;
	}

	/**
	 * This method checks whether the queue is empty or not
	 * 
	 * @return
	 */
	public boolean isQueueEmpty() {
		boolean status = false;
		if (currentSize == 0) {
			status = true;
		}
		return status;
	}

	public static void main(String a[]) {

		QueueImpl queue = new QueueImpl(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.dequeue();
		queue.enqueue(1);

		
	}
}
