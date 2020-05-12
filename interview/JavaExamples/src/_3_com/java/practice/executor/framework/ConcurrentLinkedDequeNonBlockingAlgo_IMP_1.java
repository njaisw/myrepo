package _3_com.java.practice.executor.framework;

/*
Java 7 has introduced the ConcurrentLinkedDeque class that implements a non-blocking concurrent list and in this tutorial, we will learn to use this class.
ConcurrentLinkedDeque 
Example In this example, we are going to implement an example with the following two different tasks:

    One that adds data to a list in large amount
    One that removes data from the same list in large amount
    
    Please note that ConcurrentLinkedDeque class provides more methods to get elements form the list:

    1: getFirst() and getLast(): These methods return the first and last element from the list respectively. They don’t remove the returned element from the list. If the list is empty, these methods throw a NoSuchElementExcpetion exception.
    2: peek(), peekFirst(), and peekLast(): These methods return the first and the last element of the list respectively. They don’t remove the returned element from the list. If the list is empty, these methods return a null value.
    3: remove(), removeFirst(), removeLast(): These methods return the first and the last element of the list respectively. They remove the returned element from the list. If the list is empty, these methods throw a NoSuchElementException exception.
    4: A ConcurrentLinkedDeque is an appropriate choice when many threads will share access to a common collection.
    5: Like most other concurrent collection implementations, this class does not permit the use of null elements.
    6: Iterators are weakly consistent, returning elements reflecting the state of the deque at some point at or since the creation of the iterator. They do not throw ConcurrentModificationException, and may proceed concurrently with other operations.
 */
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeNonBlockingAlgo_IMP_1 {

	public static class AddTask implements Runnable {

		private ConcurrentLinkedDeque<String> list;

		public AddTask(ConcurrentLinkedDeque<String> list) {
			this.list = list;
		}

		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			for (int i = 0; i < 10000; i++) {
				list.add(name + ": Element " + i);
			}
		}
	}

	public static class RemoveTask implements Runnable {

		private ConcurrentLinkedDeque<String> list;

		public RemoveTask(ConcurrentLinkedDeque<String> list) {
			this.list = list;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5000; i++) {
				list.pollFirst();
				list.pollLast();
			}
		}
	}

	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
		Thread threads[] = new Thread[100];

		for (int i = 0; i < threads.length; i++) {
			AddTask task = new AddTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);

		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: Size of the List: %d\n", list.size());

		for (int i = 0; i < threads.length; i++) {
			RemoveTask task = new RemoveTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		System.out.printf("Main: %d RemoveTask threads have been launched\n", threads.length);

		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: Size of the List: %d\n", list.size());
	}

}
