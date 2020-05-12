package x.com.java.practice.thread.throttle;

/*
 * In this solution, we will create a Semaphore with a number which must be equal to maximum number of tasks in blocking queue at any given point of time. So the approach works like this:

1) Before executing a task a lock in semaphore is requested
2) If lock is acquired then execution works normally; Otherwise retry will happen until lock is acquired
3) Once task is completed; lock is released to semaphore

When you run the DemoExecutor program using BlockingThreadPoolExecutor in place of CustomThreadPoolExecutor, you will not see any task rejected and all tasks will be executed successfully.
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThrottleRequestWithSemaphoreMain {

	public static void main(String[] args) {
		Integer threadCounter = 0;
		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
		BlockingThreadPoolExecutor executor = new BlockingThreadPoolExecutor(10, 20, 5000, TimeUnit.MILLISECONDS,
				blockingQueue);
		executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.out.println("DemoTask Rejected : " + ((UserTask) r).getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Lets add another time : " + ((UserTask) r).getName());
				executor.execute(r);
			}
		});
		// Let start all core threads initially
		executor.prestartAllCoreThreads();
		while (true) {
			threadCounter++;
			// Adding threads one by one
			System.out.println("Adding DemoTask : " + threadCounter);
			executor.execute(new UserTask(threadCounter.toString()));
			if (threadCounter == 1000)
				break;
		}
	}
}
