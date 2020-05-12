package _com.ds.multithreaded;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixedThreadPoolExample1 {
	private final int nThreads;
	private final PoolWorker1[] threads;
	private final LinkedBlockingQueue<Runnable> queue;
	private final Lock lock;
	private final Condition nonEmpty;

	public FixedThreadPoolExample1(int nThreads) {
		this.nThreads = nThreads;
		queue = new LinkedBlockingQueue<>();
		threads = new PoolWorker1[nThreads];
		lock = new ReentrantLock();
		nonEmpty = lock.newCondition();

		for (int i = 0; i < nThreads; i++) {
			threads[i] = new PoolWorker1();
			threads[i].start();
		}
	}

	public void execute(Runnable task) {
		try {
			lock.lockInterruptibly();
			queue.add(task);
			nonEmpty.notify();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private class PoolWorker1 extends Thread {
		public void run() {
			Runnable task = null;

			while (true) {
				try {
					lock.lockInterruptibly();
					while (queue.isEmpty()) {
						nonEmpty.wait();
					}
					task = queue.poll();
				} catch (InterruptedException e) {
					System.out.println("An error occurred while queue is waiting: " + e.getMessage());
				}finally {
					lock.unlock();
				}
				// If we don't catch RuntimeException,
				// the pool could leak threads
				try {
					task.run();
				} catch (RuntimeException e) {
					System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
				}
			}
		}
	}

}
