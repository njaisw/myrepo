package _1_com.java.practice.concurrency;

/*
 * The factory design pattern is one of the most used design patterns in the java. 
 * It is one of creational patterns and can be used to develop an object in demand of one or several classes. With this factory, we centralize the creation of objects.

The centralization of creation logic brings us some advantages e.g.

    It’s easy to change the class of the objects created or the way we create these objects.
    It’s easy to limit the creation of objects for limited resources. For example, we can only have N objects of a type.
    It’s easy to generate statistical data about the creation of the objects.

In java, we usually create threads using two ways i.e. extending thread class and implementing runnable interface. Java also provides an interface, the ThreadFactory interface, to create your own Thread object factory.
Various classes, like ThreadPoolExecutor, use constructors which accept ThreadFactory as argument. 
This factory is used when the executor creates a new thread. Using ThreadFactory you can customize the threads created by executor so that they have proper thread names, priority or even they can be set to be daemon also.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class CustomThreadFactory implements ThreadFactory {
	private int counter;
	private String name;
	private List<String> stats;

	public CustomThreadFactory(String name) {
		counter = 1;
		this.name = name;
		stats = new ArrayList<String>();
	}

	@Override
	public Thread newThread(Runnable runnable) {
		Thread t = new Thread(runnable, name + "-Thread_" + counter);
		counter++;
		stats.add(String.format("Created thread %d with name %s on %s \n", t.getId(), t.getName(), new Date()));
		return t;
	}

	public String getStats() {
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = stats.iterator();
		while (it.hasNext()) {
			buffer.append(it.next());
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		CustomThreadFactory factory = new CustomThreadFactory("CustomThreadFactory");
		Task task = new Task();
		Thread thread;
		System.out.printf("Starting the Threads\n\n");
		for (int i = 1; i <= 10; i++) {
			// Same task object passed to multiple threads
			thread = factory.newThread(task);
			thread.start();
		}
		System.out.printf("All Threads are created now\n\n");
		System.out.printf("Give me CustomThreadFactory stats:\n\n" + factory.getStats());
	}

	static class Task implements Runnable {
		@Override
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}