package _3_com.java.practice.executor.framework;

/*
This class provides thread-local variables. These variables differ from their normal counterparts in that each thread that accesses one (via its get or set method) has its own, independently initialized copy of the variable. 
ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread (e.g., a user ID or Transaction ID).

This class has following methods:

    get() : Returns the value in the current thread’s copy of this thread-local variable.
    initialValue() : Returns the current thread’s “initial value” for this thread-local variable.
    remove() : Removes the current thread’s value for this thread-local variable.
    set(T value) : Sets the current thread’s copy of this thread-local variable to the specified value.

How to use ThreadLocal?

Below example uses two thread local variables i.e. threadId and startDate. Both have been defined as “private static” fields as recommended. ‘threadId‘ will be used to identify the thread which is currently running 
and ‘startDate‘ will be used to get the time when thread started it’s execution. Above information will be printed in console to verify that each thread has maintained it’s own copy of variables.

Most common use of thread local is when you have some object that is not thread-safe, but you want to avoid synchronizing access to that object using synchronized keyword/block. Instead, give each thread its own instance of the object to work with.
A good alternative to synchronization or threadlocal is to make the variable a local variable. Local variables are always thread safe. The only thing which may prevent you to do this is your application design constraints.

 */

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDateFormat implements Runnable {

	// Atomic integer containing the next thread ID to be assigned
	private static final AtomicInteger nextId = new AtomicInteger(0);

	// Thread local variable containing each thread's ID
	private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return nextId.getAndIncrement();
		}
	};

	// Returns the current thread's unique ID, assigning it if necessary
	public int getThreadId() {
		return threadId.get();
	}

	// Returns the current thread's starting timestamp
	private static final ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		protected Date initialValue() {
			return new Date();
		}
	};

	@Override
	public void run() {
		System.out.printf("Starting Thread: %s : %s\n", getThreadId(), startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n", getThreadId(), startDate.get());
	}

}
