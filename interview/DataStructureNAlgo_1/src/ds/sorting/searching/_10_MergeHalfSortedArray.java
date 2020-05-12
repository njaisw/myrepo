package ds.sorting.searching;

//java program to Merge Two Sorted Halves Of  Array Into Single Sorted Array 

public class _10_MergeHalfSortedArray {

	// Merge two sorted halves of Array into single sorted array
	static void mergeTwoHalf(int[] A, int n) {
		int half_i = 0; // starting index of second half
		int i;
		// Temp Array store sorted resultant array
		int[] temp = new int[n];

		// First Find the point where array is divide into two half
		for (i = 0; i < n - 1; i++) {
			if (A[i] > A[i + 1]) {
				half_i = i + 1;
				break;
			}
		}

		// If Given array is all-ready sorted
		if (half_i == 0)
			return;

		// Merge two sorted arrays in single sorted array
		i = 0;
		int j = half_i;
		int k = 0;
		while (i < half_i && j < n) {
			if (A[i] < A[j])
				temp[k++] = A[i++];
			else
				temp[k++] = A[j++];
		}

		// Copy the remaining elements of A[i to half_! ]
		while (i < half_i)
			temp[k++] = A[i++];

		// Copy the remaining elements of A[ half_! to n ]
		while (j < n)
			temp[k++] = A[j++];

		for (i = 0; i < n; i++)
			A[i] = temp[i];
	}

	static public void main(String[] args) {
		int[] A = { 2, 3, 8, -1, 7, 10 };
		int n = A.length;
		mergeTwoHalf(A, n);

		for (int i = 0; i < n; i++)
			System.out.print(A[i] + " ");
	}
}
