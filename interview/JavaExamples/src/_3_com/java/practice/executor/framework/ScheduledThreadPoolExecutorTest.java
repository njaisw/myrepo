package _3_com.java.practice.executor.framework;

/*
 * Fixed thread pools or cached thread pools are good when you have to execute one unique task only once. 
 * When you need to execute a task, repeatedly N times, either N fixed number of times or infinitively after fixed delay, you should be using ScheduledThreadPoolExecutor.

ScheduledThreadPoolExecutor provides 4 methods which provide different capabilities to execute the tasks in repeated manner.

   1: ScheduledFuture schedule(Runnable command, long delay, TimeUnit unit) – Creates and executes a task that becomes enabled after the given delay.
   2: ScheduledFuture schedule(Callable callable, long delay, TimeUnit unit) – Creates and executes a ScheduledFuture that becomes enabled after the given delay.
   3: ScheduledFuture scheduleAtFixedRate(Runnable command, long initialDelay, long delay, TimeUnit unit) – Creates and executes a periodic action that becomes enabled first after the given initial delay, and subsequently with the given delay period. If any execution of this task takes longer than its period, then subsequent executions may start late, but will not concurrently execute.
   4: ScheduledFuture scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) – Creates and executes a periodic action that becomes enabled first after the given initial delay, and subsequently with the given delay period. No matter how much time a long running task takes, there will be a fixed delay time gap between two executions.
 
 */

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);

		Task task = new Task("Repeat Task");
		System.out.println("Created : " + task.getName());

		executor.scheduleWithFixedDelay(task, 2, 2, TimeUnit.SECONDS);
	}
}

class Task implements Runnable {
	private String name;

	public Task(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void run() {
		System.out.println("Executing : " + name + ", Current Seconds : " + new Date().getSeconds());
	}
}