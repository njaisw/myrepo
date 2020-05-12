package ds.slidingwindow;

//A Java program to find if there is a zero sum subarray 

/*
 * Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.

Examples :

Input: {4, 2, -3, 1, 6}
Output: true 
There is a subarray with zero sum from index 1 to 3.

Input: {4, 2, 0, 1, 6}
Output: true 
There is a subarray with zero sum from index 2 to 2.

Input: {-3, 2, 3, 1, 6}
Output: false
There is no subarray with zero sum.

arr[] = {1, 4, -2, -2, 5, -4, 3}

If we consider all prefix sums, we can
notice that there is a subarray with 0
sum when :
1) Either a prefix sum repeats or
2) Or prefix sum becomes 0.

Prefix sums for above array are:
1, 5, 3, 1, 6, 2, 5

Since prefix sum 1 repeats, we have a subarray
with 0 sum. 
 */
import java.util.HashMap;

public class _ZeroSubArray_IMP_3 {

	static Boolean subArrayExists(int arr[]) {

		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			// Return true in following cases
			// a) Current element is 0
			// b) sum of elements from 0 to i is 0
			// c) sum is already present in hash map
			if (arr[i] == 0 || sum == 0 || hM.get(sum) != null)
				return true;

			// Add sum to hash map
			hM.put(sum, i);
		}
		// We reach here only when there is no subarray with 0 sum
		return false;
	}

	public static void main(String arg[]) {
		int arr[] = { 4, 2, -3, 1, 6 };
		if (subArrayExists(arr))
			System.out.println("Found a subarray with 0 sum");
		else
			System.out.println("No Such Sub Array Exists!");
	}
}
