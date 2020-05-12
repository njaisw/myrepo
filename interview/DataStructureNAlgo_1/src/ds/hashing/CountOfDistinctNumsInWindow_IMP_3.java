package ds.hashing;

/*
Given an array of size n and an integer k, return the of count of distinct numbers in all windows of size k. 
Input:  arr[] = {1, 2, 1, 3, 4, 2, 3}; k = 4
Output: 3 4 4 3

Explanation:
	First window is {1, 2, 1, 3}, count of distinct numbers is 3
	Second window is {2, 1, 3, 4} count of distinct numbers is 4
	Third window is {1, 3, 4, 2} count of distinct numbers is 4
	Fourth window is {3, 4, 2, 3} count of distinct numbers is 3
 * */
import java.util.HashMap;

public class CountOfDistinctNumsInWindow_IMP_3 {
	static void countDistinct(int arr[], int k) {
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int dist_count = 0;

		// Traverse the first window and store count of every element in hash map
		for (int i = 0; i < k; i++) {
			if (hM.get(arr[i]) == null) {
				hM.put(arr[i], 1);
				dist_count++;
			} else {
				int count = hM.get(arr[i]);
				hM.put(arr[i], count + 1);
			}
		}

		// Print count of first window
		System.out.println(dist_count);

		// Traverse through the remaining array
		for (int i = k; i < arr.length; i++) {
			// Remove first element of previous window If there was only one occurrence,
			// then reduce distinct count.
			if (hM.get(arr[i - k]) == 1) {
				hM.remove(arr[i - k]);
				dist_count--;
			} else {
				int count = hM.get(arr[i - k]);
				hM.put(arr[i - k], count - 1);
			}
			// Add new element of current window If this element appears first time,
			// increment distinct element count
			if (hM.get(arr[i]) == null) {
				hM.put(arr[i], 1);
				dist_count++;
			} else {
				int count = hM.get(arr[i]);
				hM.put(arr[i], count + 1);
			}
			// Print count of current window
			System.out.println(dist_count);
		}
	}

	public static void main(String arg[]) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;
		countDistinct(arr, k);
	}
}
