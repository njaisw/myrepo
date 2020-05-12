package _4_com.java.practice.misc_4;

/*
 * The ThreadLocal class in Java enables you to create variables that can only be read and written by the same thread. Thus, even if two threads are executing the same code, 
 * and the code has a reference to a ThreadLocal variable, then the two threads cannot see each other's ThreadLocal variables. 
 * 
 * As you can see, you instantiate a new ThreadLocal object. This only needs to be done once per thread. 
 * Even if different threads execute the same code which accesses a ThreadLococal, each thread will see only its own ThreadLocal instance.
 *  Even if two different threads set different values on the same ThreadLocal object, they cannot see each other's values. 
 */

public class ThreadLocalExample {

	public static class MyRunnable implements Runnable {

		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		@Override
		public void run() {
			threadLocal.set((int) (Math.random() * 100D));

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			System.out.println(threadLocal.get());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}

}
