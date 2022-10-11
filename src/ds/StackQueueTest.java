package ds;

public class StackQueueTest {

	ListNode top;
	int size = 0;
	ListNode F;
	ListNode R;

	public StackQueueTest() {
		this.top = null;
		this.size = 3;
		this.F = null;
		this.R = null;
	}

	public void enqueue(int val) {
		ListNode node1 = new ListNode(val);
		if (F == null) {
			this.F = this.R = node1;
			return;
		} else {
			this.R.next = node1;
			this.R = node1;
		}
	}

	public int deQueue() {

		if (this.F == null)
			return -1;

		ListNode temp = this.F;
		this.F = this.F.next;

		if (this.F == null)
			this.R = null;
		
		return temp.val;
	}

	public void push(int val) {
		if (size == 0) {
			System.out.println("Overflow");
			return;
		}
		ListNode node = new ListNode(val);
		if (top == null)
			top = node;
		else
			node.next = top;
		top = node;
		size--;
	}

	public int pop() {
		int data = 0;
		size++;
		if (size >= 3) {
			System.out.println("underflow");
			return -1;
		}
		if (!isEmpty()) {
			data = top.val;
			top = top.next;
			return data;
		} else {
			return -1;
		}
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int peek() {
		if (!isEmpty())
			return top.val;
		else
			return -1;
	}

	public static void main(String[] args) {

		StackQueueTest st = new StackQueueTest();
		st.push(10);
		st.push(11);
		st.push(12);
		st.push(13);

		System.out.println("Peek operation " + st.peek());
		System.out.println("1st Pop Operation " + st.pop());
		System.out.println("Peek operation " + st.peek());
		System.out.println("2nd Pop Operation " + st.pop());
		System.out.println("Peek operation " + st.peek());
		System.out.println("2nd Pop Operation " + st.pop());
		System.out.println("2nd Pop Operation " + st.pop());
		
		
		st.enqueue(10);
		st.enqueue(11);
		st.enqueue(12);
		
		System.out.println(st.deQueue());
		System.out.println(st.deQueue());
	}

}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
		next = null;
	}
}