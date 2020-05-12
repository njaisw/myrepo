package _2_com.java.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by rajeevkumarsingh on 11/05/17.
 * https://stackoverflow.com/questions/37395689/one-thread-reading-other-thread-writing-to-shared-variable
 * 
 * Feasible solutions:

    If only one thread is writing and other thread is reading as per your code, just add volatile in front of count variable.

    If multiple threads write and read data, change count to AtomicInteger.

    Making write and read methods as synchronized, which is not a good solution. AtomicInteger provides best solution.

 */

class FineGrainedSynchronizedCounter {
	private int count = 0;

	public void increment() {
		// Synchronized Block
		synchronized (this) {
			count = count + 1;
		}
	}

	public int getCount() {
		return count;
	}
}

public class SynchronizedBlockExample {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		FineGrainedSynchronizedCounter counter = new FineGrainedSynchronizedCounter();

		for (int i = 0; i < 1000; i++) {
			executorService.submit(() -> counter.increment());
		}

		executorService.shutdown();
		executorService.awaitTermination(60, TimeUnit.SECONDS);

		System.out.println("Final count is " + counter.getCount());
	}
}
