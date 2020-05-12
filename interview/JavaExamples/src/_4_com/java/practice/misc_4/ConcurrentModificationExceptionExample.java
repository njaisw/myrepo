package _4_com.java.practice.misc_4;

/*
 * 
 *  java.util.ConcurrentModificationException is a very common exception when working with java collection classes.
 *  Java Collection classes are fail-fast, which means if the Collection will be changed while some thread is traversing over it using iterator, 
 *  the iterator.next() will throw ConcurrentModificationException. Concurrent modification exception can come in case of multithreaded as well as single threaded java programming environment.
 *  
1: To Avoid ConcurrentModificationException in multi-threaded environment

   a: You can convert the list to an array and then iterate on the array. This approach works well for small or medium size list but if the list is large then it will affect the performance a lot.
    
   b: You can lock the list while iterating by putting it in a synchronized block. This approach is not recommended because it will cease the benefits of multithreading.
    
   c:If you are using JDK1.5 or higher then you can use ConcurrentHashMap and CopyOnWriteArrayList classes. This is the recommended approach to avoid concurrent modification exception.
   
   Concurrent Collection classes can be modified safely, they will not throw ConcurrentModificationException.
   In case of CopyOnWriteArrayList, iterator doesn’t accommodate the changes in the list and works on the original list.

2: To Avoid ConcurrentModificationException in single-threaded environment

a: You can use the iterator remove() function to remove the object from underlying collection object. But in this case you can remove the same object and not any other object from the list.
b: If you are working on single-threaded environment and want your code to take care of the extra added objects in the list then you can do so using for loop rather than iterator.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConcurrentModificationExceptionExample {

	public static void main(String args[]) {
		List<String> myList = new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3"))
				myList.remove(value);
			// it.remove();
		}

		Iterator<String> it2 = myList.iterator();
		while (it2.hasNext()) {
			String value = it2.next();
			System.out.println("List Value:" + value);
		}

		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				myMap.remove("2");
				myMap.put("1", "4");
				// myMap.put("4", "4");
			}
		}

	}
}