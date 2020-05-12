package _1_com.java.practice.concurrency;

/*
As we are already aware that there are two kinds of exceptions in Java. 
Checked exceptions and Unchecked exceptions. Checked exceptions must be specified in the throws clause of a method or caught inside them. 
Unchecked exceptions don’t have to be specified or caught. When a checked exception is thrown inside the run() method of a Thread object, we have to catch and treat it accordingly, because the run() method doesn’t accept a throws clause. 

But when an unchecked exception is thrown inside the run() method of a Thread object, the default behavior is to write the stack trace in the console (or log it inside error log file) and exit the program.

Fortunately, Java provides us with a mechanism to catch and treat the unchecked exceptions thrown in a Thread object to avoid the program ending. This can be done using UncaughtExceptionHandler.

Let’s take an example of UncaughtExceptionHandler usage. In this example, we have created a thread which tries to parse few strings which are supposed to be integers. 
We have written the run() method such that it throws a “java.lang.NumberFormatException” during it’s execution. 
As program does not try to catch this exception, exception floats through JVM level and thread gets killed. This is absolutely normal behavior but it MAY NOT be desired behavior.
 */
import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionHandlerExample implements UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
		new Thread(new Task()).start();
	}

	static class Task implements Runnable {
		@Override
		public void run() {
			//Thread set UncaughtExceptionHandler
			Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandlerExample());
			System.out.println(Integer.parseInt("123"));
			System.out.println(Integer.parseInt("234"));
			System.out.println(Integer.parseInt("345"));
			System.out.println(Integer.parseInt("XYZ")); // This will cause NumberFormatException
			System.out.println(Integer.parseInt("456"));
		}
	}

	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.start();
	}
}