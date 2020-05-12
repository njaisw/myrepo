package _1_com.java.practice.concurrency;

/*
The Java BlockingQueue interface in the java.util.concurrent package represents a queue which is thread safe to put into, and take instances from. 
The producing thread will keep producing new objects and insert them into the queue, until the queue reaches some upper bound on what it can contain. It's limit, in other words. 
If the blocking queue reaches its upper limit, the producing thread is blocked while trying to insert the new object. It remains blocked until a consuming thread takes an object out of the queue.

The consuming thread keeps taking objects out of the blocking queue, and processes them. 
If the consuming thread tries to take an object out of an empty queue, the consuming thread is blocked until a producing thread puts an object into the queue. 
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerWithBlockingQueue {

	public static void main(String[] args) throws Exception {

		BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}

	public static class Producer implements Runnable {

		protected BlockingQueue<String> queue = null;

		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			try {
				queue.put("1");
				Thread.sleep(1000);
				queue.put("2");
				Thread.sleep(1000);
				queue.put("3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Consumer implements Runnable {

		protected BlockingQueue<String> queue = null;

		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			try {
				System.out.println(queue.take());
				System.out.println(queue.take());
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}