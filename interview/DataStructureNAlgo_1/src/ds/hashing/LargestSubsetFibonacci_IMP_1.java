package ds.hashing;

/*Given an array with positive number the task is that we find largest subset from array that contain elements which are Fibonacci numbers.
Input  : arr[] = {0, 2, 8, 5, 2, 1, 4, 13, 23};
Output : subset[] = {0, 2, 8, 5, 2, 1, 13, 23}

1.	Find max in the array 
2.	Generate Fibonacci numbers till the max and store it in hash table. 
3.	Traverse array again if the number is present in hash table then add it to the result.
*/

import java.util.*;

public class LargestSubsetFibonacci_IMP_1 {
	// Prints largest subset of an array whose
	// all elements are fibonacci numbers
	public static void findFibSubset(Integer[] x) {
		// TODO Collections max
		Integer max = Collections.max(Arrays.asList(x));
		List<Integer> fib = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();

		// Generate all Fibonacci numbers till max and store them
		Integer a = 0;
		Integer b = 1;
		while (b < max) {
			Integer c = a + b;
			a = b;
			b = c;
			fib.add(c);
		}

		// Now iterate through all numbers and quickly check for Fibonacci
		for (Integer i = 0; i < x.length; i++) {
			if (fib.contains(x[i])) {
				result.add(x[i]);
			}
		}
		System.out.println(result);
	}

	public static void main(String args[]) {
		Integer[] a = { 4, 2, 8, 5, 20, 1, 40, 13, 23 };
		findFibSubset(a);
	}
}
