package ds.slidingwindow;

/*
Given two binary arrays arr1[] and arr2[] of same size n.
Find length of the longest common span (i, j) where j >= i such that arr1[i] + arr1[i+1] + …. + arr1[j] = arr2[i] + arr2[i+1] + …. + arr2[j].

Input: arr1[] = {0, 1, 0, 0, 0, 0};
       arr2[] = {1, 0, 1, 0, 0, 1};
Output: 4
The longest span with same sum is from index 1 to 4.

Input: arr1[] = {0, 1, 0, 1, 1, 1, 1};
       arr2[] = {1, 1, 1, 1, 1, 0, 1};
Output: 6
The longest span with same sum is from index 1 to 6.

Input: arr1[] = {0, 0, 0};
       arr2[] = {1, 1, 1};
Output: 0

Input: arr1[] = {0, 0, 1, 0};
       arr2[] = {1, 1, 1, 1};
Output: 1

Method 2 (Using Auxiliary Array)
The idea is based on below observations.
    Since there are total n elements, maximum sum is n for both arrays.
    Difference between two sums varies from -n to n. So there are total 2n + 1 possible values of difference.
    If differences between prefix sums of two arrays become same at two points, then subarrays between these two points have same sum.

Below is Complete Algorithm.

    Create an auxiliary array of size 2n+1 to store starting points of all possible values of differences (Note that possible values of differences vary from -n to n, i.e., there are total 2n+1 possible values)
    Initialize starting points of all differences as -1.
    Initialize maxLen as 0 and prefix sums of both arrays as 0, preSum1 = 0, preSum2 = 0
    Travers both arrays from i = 0 to n-1.
        Update prefix sums: preSum1 += arr1[i], preSum2 += arr2[i]
        Compute difference of current prefix sums: curr_diff = preSum1 – preSum2
        Find index in diff array: diffIndex = n + curr_diff // curr_diff can be negative and can go till -n
        If curr_diff is 0, then i+1 is maxLen so far
        Else If curr_diff is seen first time, i.e., starting point of current diff is -1, then update starting point as i
        Else (curr_diff is NOT seen first time), then consider i as ending point and find length of current same sum span. If this length is more, then update maxLen
    Return maxLen
 */

public class X_LongestSumSubArray_IMP_3X {
	static int arr1[] = new int[] { 0, 1, 0, 1, 1, 1, 1 };
	static int arr2[] = new int[] { 1, 1, 1, 1, 1, 0, 1 };

	// Returns length of the longest common sum in arr1[] and arr2[].
	static int longestCommonSum(int n) {

		int maxLen = 0;
		int preSum1 = 0, preSum2 = 0;

		// Create an array to store staring and ending indexes of all possible diff
		// values. diff[i] would store starting and ending points for difference "i-n"
		int diff[] = new int[2 * n + 1];

		// Initialize all starting and ending values as -1.
		for (int i = 0; i < diff.length; i++) {
			diff[i] = -1;
		}

		for (int i = 0; i < n; i++) {

			preSum1 += arr1[i];
			preSum2 += arr2[i];

			// Comput current diff and index to be used in diff array. Note that diff can be
			// negative and can have minimum value as -1.
			int curr_diff = preSum1 - preSum2;
			int diffIndex = n + curr_diff;

			// If current diff is 0, then there are same number of 1's so far in both
			// arrays, i.e., (i+1) is maximum length.
			if (curr_diff == 0)
				maxLen = i + 1;

			// If current diff is seen first time, then update starting index of diff.
			else if (diff[diffIndex] == -1)
				diff[diffIndex] = i;
			else {
				// Find lenght of this same sum common span
				int len = i - diff[diffIndex];
				// Update max len if needed
				if (len > maxLen)
					maxLen = len;
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.print("Length of the longest common span with same sum is ");
		System.out.println(longestCommonSum(arr1.length));
	}
}
