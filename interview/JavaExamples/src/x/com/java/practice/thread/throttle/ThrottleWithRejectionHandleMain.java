package x.com.java.practice.thread.throttle;

/*
 * In one of my previous post related to BlockingQueue and ThreadPoolExecutor, We learned about creating a CustomThreadPoolExecutor which had following capabilities:

1) Tasks being submitted to blocking queue
2) An executor which picks up the task from queue and execute them
3) Had overridden beforeExecute() and afterExecute() methods to perform some extra activities if needed
4) Attached a RejectedExecutionHandler which handle the task if it got rejected because the queue was full

Our approach was good enough already and capable of handling most of the practical scenarios. Now let’s add one more concept into it which may prove beneficial in some conditions. This concept is around throttling of task submission in queue.

*/

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThrottleWithRejectionHandleMain {
	public static void main(String[] args) {
		Integer threadCounter = 0;
		// TODO The size of blocking Queue is 50 which means if anything above 50 is
		// tried to put here then the call might get blocked
		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
		CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10, 20, 5000, TimeUnit.MILLISECONDS,
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
			// System.out.println("Adding DemoTask : " + threadCounter);
			executor.execute(new UserTask(threadCounter.toString()));
			if (threadCounter == 1000)
				break;
		}
	}
}