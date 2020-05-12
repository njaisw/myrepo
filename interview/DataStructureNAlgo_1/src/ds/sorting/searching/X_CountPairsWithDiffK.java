package ds.sorting.searching;

/*
 * Given an integer array and a positive integer k, count all distinct pairs with difference equal to k. 
Examples: 
Input: arr[] = {1, 5, 3, 4, 2}, k = 3
Output: 2
There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2} 

 */
import java.util.Arrays;

public class X_CountPairsWithDiffK {

	// Standard binary search function //
	static int binarySearch(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if (x == arr[mid])
				return mid;
			if (x > arr[mid])
				return binarySearch(arr, (mid + 1), high, x);
			else
				return binarySearch(arr, low, (mid - 1), x);
		}
		return -1;
	}

	// Returns count of pairs with
	// difference k in arr[] of size n.
	static int countPairsWithDiffK(int arr[], int n, int k) {
		int count = 0, i;

		Arrays.sort(arr);

		// code to remove duplicates from arr[]

		// Pick a first element point
		for (i = 0; i < n - 1; i++)
			if (binarySearch(arr, i + 1, n - 1, arr[i] + k) != -1)
				count++;

		return count;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 5, 3, 4, 2 };
		int n = arr.length;
		int k = 3;
		System.out.println("Count of pairs with given diff is " + countPairsWithDiffK(arr, n, k));
	}
}
