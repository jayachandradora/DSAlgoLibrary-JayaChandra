package ds;

/*
 * Java Program to Implement Stack
 */

import java.util.*;

/*  Class arrayStack  */

public class StackImplement {

	protected int arr[];
	protected int top, size;

	/* Constructor for arrayStack */
	public StackImplement(int n) {
		size = n;// Size of stack
		arr = new int[size]; // initializing array size here
		top = -1; //counter of array
	}

	/* Function to check if stack is empty */
	public boolean isEmpty() {
		return top == -1;
	}

	/* Function to check if stack is full */
	public boolean isFull() {
		return top == size - 1;
	}

	/* Function to get the size of the stack */
	public int getSize() {
		return top + 1;
	}

	/* Function to check the top element of the stack */
	public int peek() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return arr[top];
	}

	/* Function to add an element to the stack */
	public void push(int i) {
		if (top >= size)
			throw new IndexOutOfBoundsException("Overflow Exception");

		arr[++top] = i;
	}

	/* Function to delete an element from the stack */
	public int pop() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return arr[top--];
	}

	/* Function to display the status of the stack */
	public void display() {
		System.out.print("\nStack = ");
		if (top == -1) {
			System.out.print("Empty\n");
			return;
		}
		for (int i = top; i >= 0; i--)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		StackImplement siObj = new StackImplement(5);
		// System.out.println("Pick " + siObj.peek());

		siObj.display();
		siObj.push(11);
		siObj.push(12);
		// siObj.push(13);
		// siObj.push(14);
		// siObj.push(15);
		// siObj.push(16);
		// siObj.push(17);

		// System.out.println("POP " + siObj.pop());
		// System.out.println("Pick " + siObj.peek());
		// System.out.println("POP " + siObj.pop());
		System.out.println("Pick " + siObj.peek());

		siObj.display();
		System.out.println("Get Size " + siObj.getSize());
		System.out.println("Top " + siObj.top);

	}
}
