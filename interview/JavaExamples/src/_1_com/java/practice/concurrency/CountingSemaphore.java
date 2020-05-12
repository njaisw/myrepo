package _1_com.java.practice.concurrency;

import java.util.concurrent.Semaphore;

/*
 * a Counting semaphore with one permit is known as binary semaphore because it has only two state permit available or permit unavailable. 
 * Binary semaphore can be used to implement mutual exclusion or critical section where only one thread is allowed to execute. 
 * Thread will wait on acquire() until Thread inside critical section release permit by calling release() on semaphore.

Read more: https://javarevisited.blogspot.com/2012/05/counting-semaphore-example-in-java-5.html#ixzz5ek9Sdr4O

 */
public class CountingSemaphore {

	private Semaphore binary = new Semaphore(1);

	public static void main(String args[]) {
		
		final CountingSemaphore test = new CountingSemaphore();
		
		new Thread(() -> test.mutualExclusion()).start();

		new Thread(test::mutualExclusion).start();

	}

	private void mutualExclusion() {
		try {
			binary.acquire();

			// mutual exclusive region
			System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
			Thread.sleep(1000);

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			binary.release();
			System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
		}
	}

}
