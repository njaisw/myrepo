package ds.sorting.searching;

/*
 * Given a sorted array containing only numbers 0 and 1, the task is to find the transition point efficiently. Transition point is a point where “0” ends and “1” begins.

Input : 0 0 0 1 1
Output : 3
Index of first 1 is 3
 */
public class _25_TransitionPointInBinaryArray {
	// Method to find the transition point
	static int findTransitionPoint(int arr[], int n) {
		int lb = 0, ub = n - 1;
		while (lb <= ub) {
			int mid = (lb + ub) / 2;
			if (arr[mid] == 0)
				lb = mid + 1;
			else if (arr[mid] == 1) {
				// Check if it is the left most 1 Return mid, if yes
				if (arr[mid - 1] == 0)
					return mid;
				// Else update upper_bound
				ub = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int arr[] = { 0, 0, 0, 0, 1, 1 };

		int point = findTransitionPoint(arr, arr.length);

		System.out.println(point >= 0 ? "Transition point is " + point : "There is no transition point");
	}
}
