package ds.sorting.searching;

/*
 * Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest 
 element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.

Examples :

For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array

 */
public class _17_1_CelingOfASortedArray {
	/* Function to get index of ceiling of x in arr[low..high] */
	static int ceilSearch(int arr[], int low, int high, int x) {
		int mid;

		if (x <= arr[low])
			return low;

		if (x > arr[high])
			return -1;

		mid = (low + high) / 2; /* low + (high - low)/2 */

		if (arr[mid] == x)
			return mid;
		else if (arr[mid] < x) {
			// If x is greater than arr[mid], then either arr[mid + 1] is ceiling of x or
			// ceiling lies in arr[mid+1...high]
			if (mid + 1 <= high && x <= arr[mid + 1])
				return mid + 1;
			else
				return ceilSearch(arr, mid + 1, high, x);
		} else {
			// If x is smaller than arr[mid], then either arr[mid] is ceiling of x or
			// ceiling lies in arr[mid-1...high]
			if (mid - 1 >= low && x > arr[mid - 1])
				return mid;
			else
				return ceilSearch(arr, low, mid - 1, x);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
		int n = arr.length;
		int x = 8;
		int index = ceilSearch(arr, 0, n - 1, x);
		if (index == -1)
			System.out.println("Ceiling of " + x + " doesn't exist in array");
		else
			System.out.println("ceiling of " + x + " is " + arr[index]);
	}
}
