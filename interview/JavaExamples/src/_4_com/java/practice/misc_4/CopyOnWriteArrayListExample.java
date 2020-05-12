package _4_com.java.practice.misc_4;

/*
 As the name suggests CopyOnWriteArrayList creates a copy of underlying ArrayList with every mutation operation e.g. add, remove, or when you set values. 
 That's why it is only suitable for a small list of values which are read frequently but modified rarely e.g. a list of configurations.

Normally CopyOnWriteArrayList is very expensive because it involves costly Array copy with every writes operation 
but it's very efficient if you have a List where Iteration outnumbers mutation e.g. you mostly need to iterate the ArrayList and don't modify it too often.

Iterator of CopyOnWriteArrayList is fail-safe and doesn't throw ConcurrentModificationException even if underlying CopyOnWriteArrayList is modified once Iteration
begins because Iterator is operating on a separate copy of ArrayList. Consequently, all the updates made on CopyOnWriteArrayList is not available to Iterator (see Java Fundamentals: Collections).

 Difference between CopyOnWriteArrayList and ArrayList in Java.

Now let's see Some difference between ArrayList and CopyOnWriteArrayList in Java, which is another implementation of List interface :

1) First and foremost difference between CopyOnWriteArrayList and ArrayList in Java is that CopyOnWriteArrayList is a thread-safe collection while ArrayList is not thread-safe and can not be used in the multi-threaded environment.

2) The second difference between ArrayList and CopyOnWriteArrayList is that Iterator of ArrayList is fail-fast and throw ConcurrentModificationException once detect any modification in List once iteration begins 
but Iterator of CopyOnWriteArrayList is fail-safe and doesn't throw ConcurrentModificationException.

3) The third difference between CopyOnWriteArrayList vs ArrayList is that Iterator of former doesn't support remove operation while Iterator of later supports remove() operation.

Read more: http://www.java67.com/2012/09/what-is-copyonwritearraylist-in-java-example-vs-arraylist.html#ixzz5ej7X5mYf
 * 
 */
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

/**
 *
 * Java program to demonstrate What is CopyOnWriteArrayList in Java, Iterator of
 * CopyOnWriteArrayList doesn’t support add, remove or any modification
 * operation.
 *
 * @author Java67
 */
public class CopyOnWriteArrayListExample {

	public static void main(String args[]) {

		CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<String>();
		threadSafeList.add("Java");
		threadSafeList.add("J2EE");
		threadSafeList.add("Collection");

		// add, remove operator is not supported by CopyOnWriteArrayList iterator
		Iterator<String> failSafeIterator = threadSafeList.iterator();
		while (failSafeIterator.hasNext()) {
			System.out.printf("Read from CopyOnWriteArrayList : %s %n", failSafeIterator.next());
			failSafeIterator.remove(); // not supported in CopyOnWriteArrayList in Java
			
		}
	}
}
