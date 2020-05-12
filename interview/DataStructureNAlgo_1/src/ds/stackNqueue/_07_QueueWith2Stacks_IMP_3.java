package ds.stackNqueue;

/* Java Program to implement a queue using two stacks */
import java.util.Stack;

public class _07_QueueWith2Stacks_IMP_3 {
	static class Queue {
		Stack<Integer> stack1;
		Stack<Integer> stack2;
	}

	static void push(Stack<Integer> top_ref, int new_data) {
		// Push the data onto the stack
		top_ref.push(new_data);
	}

	/* Function to pop an item from stack */
	static int pop(Stack<Integer> top_ref) {
		/* If stack is empty then error */
		if (top_ref.isEmpty()) {
			System.out.println("Stack Underflow");
			System.exit(0);
		}

		// pop the data from the stack
		return top_ref.pop();
	}

	// Function to enqueue an item to the queue
	static void enQueue(Queue q, int x) {
		push(q.stack1, x);
	}

	/* Function to deQueue an item from queue */
	static int deQueue(Queue q) {
		int x;

		/* If both stacks are empty then error */
		if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
			System.out.println("Q is empty");
			System.exit(0);
		}

		// TODO Move elements from stack1 to stack 2 only if stack2 is empty
		if (q.stack2.isEmpty()) {
			while (!q.stack1.isEmpty()) {
				x = pop(q.stack1);
				push(q.stack2, x);
			}
		}
		x = pop(q.stack2);
		return x;
	}

	public static void main(String args[]) {

		Queue q = new Queue();
		q.stack1 = new Stack<>();
		q.stack2 = new Stack<>();
		enQueue(q, 1);
		enQueue(q, 2);
		enQueue(q, 3);

		System.out.print(deQueue(q) + " ");
		System.out.print(deQueue(q) + " ");
		System.out.println(deQueue(q) + " ");
	}
}
