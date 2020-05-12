package _3_com.java.practice.executor.framework;
//https://howtodoinjava.com/java/multi-threading/executor-framework-tutorial/
/*
 * It’s not necessary that each Runnable should be executed in a separate thread. 
 * Sometimes, we need to do multiple jobs in a single thread and each job is instance of Runnable.
 * To design this type of solution, a multi runnable should be used. 
 * This multi runnable is nothing but a collection of runnables which needs to be executed. Only addition is that this multi runnable is also a Runnable itself.

Below is the list of tasks which needs to be executed in a single thread.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiTaskExecutor {

	public static void main(String[] args) {

		BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(10);
		RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandelerImpl();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, worksQueue, rejectionHandler);

		executor.prestartAllCoreThreads();

		List<Runnable> taskGroup = new ArrayList<Runnable>();
		taskGroup.add(new TestOne());
		taskGroup.add(new TestTwo());
		taskGroup.add(new TestThree());
        //TODO check implementation
		worksQueue.add(new MultiRunnable(taskGroup));
	}

	

	public static class MultiRunnable implements Runnable {

		private final List<Runnable> runnables;

		public MultiRunnable(List<Runnable> runnables) {
			this.runnables = runnables;
		}

		@Override
		public void run() {
			for (Runnable runnable : runnables) {
				new Thread(runnable).start();
			}
		}
	}
}

class RejectedExecutionHandelerImpl implements RejectedExecutionHandler {
	@Override
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
		System.out.println(runnable.toString() + " : I've been rejected ! ");
	}
}

class TestThree implements Runnable {
	@Override
	public void run() {
		System.out.println("Executing Task Three");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
