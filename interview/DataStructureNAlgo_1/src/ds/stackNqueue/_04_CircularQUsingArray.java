package ds.stackNqueue;

//Java program for array implementation of queue 

//Driver class 
public class _04_CircularQUsingArray {
	int front, rear, size;
	int capacity;
	int array[];

	public _04_CircularQUsingArray(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity - 1;
		array = new int[this.capacity];

	}

	// Queue is full when size becomes equal to
	// the capacity
	boolean isFull(_04_CircularQUsingArray queue) {
		return (queue.size == queue.capacity);
	}

	// Queue is empty when size is 0
	boolean isEmpty(_04_CircularQUsingArray queue) {
		return (queue.size == 0);
	}

	// Method to add an item to the queue.
	// It changes rear and size
	void enqueue(int item) {
		if (isFull(this))
			return;
		this.rear = (this.rear + 1) % this.capacity;
		this.array[this.rear] = item;
		this.size = this.size + 1;
		System.out.println(item + " enqueued to queue");
	}

	// Method to remove an item from queue.
	// It changes front and size
	int dequeue() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		int item = this.array[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size = this.size - 1;
		return item;
	}

	// Method to get front of queue
	int front() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		return this.array[this.front];
	}

	// Method to get rear of queue
	int rear() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		return this.array[this.rear];
	}

	public static void main(String[] args) {
		_04_CircularQUsingArray queue = new _04_CircularQUsingArray(1000);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println(queue.dequeue() + " dequeued from queue\n");

		System.out.println("Front item is " + queue.front());

		System.out.println("Rear item is " + queue.rear());
	}
}
