package ds.hashing;

/*
Given two arrays: arr1[0..m-1] and arr2[0..n-1]. 
Find whether arr2[] is a subset of arr1[] or not. Both the arrays are not in sorted order. It may be assumed that elements in both array are distinct.
	Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
	Output: arr2[] is a subset of arr1[]
	Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
	Output: arr2[] is not a subset of arr1[]
		1) Sort both arrays: arr1[] and arr2[] O(mLogm + nLogn)
		2) Use Merge type of process to see if all elements of sorted arr2[] are present in sorted arr1[].
 
 */
import java.util.Arrays;

public class IsSubsetArray_IMP_2 {

	static boolean isSubset(int arr1[], int arr2[], int m, int n) {
		int i = 0, j = 0;

		if (m < n)
			return false;

		Arrays.sort(arr1); // sorts arr1
		Arrays.sort(arr2); // sorts arr2

		while (i < n && j < m) {
			if (arr1[j] < arr2[i])
				j++;
			else if (arr1[j] == arr2[i]) {
				j++;
				i++;
			} else if (arr1[j] > arr2[i])
				return false;
		}

		if (i < n)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		int arr1[] = { 11, 1, 13, 21, 3, 7 };
		int arr2[] = { 11, 3, 7, 1 };
		int m = arr1.length;
		int n = arr2.length;

		if (isSubset(arr1, arr2, m, n))
			System.out.println("arr2 is a subset of arr1");
		else
			System.out.println("arr2 is not a subset of arr1");
	}
}
