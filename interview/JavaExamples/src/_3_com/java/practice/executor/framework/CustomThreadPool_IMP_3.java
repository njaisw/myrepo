package _3_com.java.practice.executor.framework;

import java.util.concurrent.LinkedBlockingQueue;

/*
 * Though Java has very robust thread pool functionality through Executor framework. And you should not be creating your own custom thread pool without executor. 
 * I will strongly discourage any such attempt. Yet if you would like to create it for your own learning, the given below is such thread pool implementation in Java.
 */
@SuppressWarnings("unused")
public class CustomThreadPool_IMP_3 {
	// Thread pool size
	private final int poolSize;

	// Internally pool is an array
	private final WorkerThread[] workers;

	// FIFO ordering
	private final LinkedBlockingQueue<Runnable> queue;

	public CustomThreadPool_IMP_3(int poolSize) {
		this.poolSize = poolSize;
		queue = new LinkedBlockingQueue<Runnable>();
		workers = new WorkerThread[poolSize];

		for (int i = 0; i < poolSize; i++) {
			workers[i] = new WorkerThread();
			workers[i].start();
		}
	}

	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}

	private class WorkerThread extends Thread {
		public void run() {
			Runnable task;

			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							System.out.println("An error occurred while queue is waiting: " + e.getMessage());
						}
					}
					task = (Runnable) queue.poll();
				}

				try {
					task.run();
				} catch (RuntimeException e) {
					System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
				}
			}
		}
	}

	public void shutdown() {
		System.out.println("Shutting down thread pool");
		for (int i = 0; i < poolSize; i++) {
			workers[i] = null;
		}
	}

	public static void main(String[] args) {
		CustomThreadPool_IMP_3 customThreadPool = new CustomThreadPool_IMP_3(2);

		for (int i = 1; i <= 5; i++) {
			Task task = new Task("Task " + i);
			System.out.println("Created : " + task.getName());

			customThreadPool.execute(task);
		}
	}
}