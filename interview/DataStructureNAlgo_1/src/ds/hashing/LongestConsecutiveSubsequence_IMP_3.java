package ds.hashing;

/*
Input: arr[] = {1, 9, 3, 10, 4, 20, 2};
Output: 4
The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements

1) Create an empty hash.
2) Insert all array elements to hash.
3) Do following for every element arr[i]
....a) Check if this element is the starting point of a subsequence.  To check this, we simply look for
       arr[i] - 1 in hash, if not found, then this is the first element a subsequence.  
    
       If this element is a first element, then count number of elements in the consecutive starting 
       with this element.If count is more than current res, then update  res.

 */
import java.util.HashSet;

public class LongestConsecutiveSubsequence_IMP_3 {
	// Returns length of the longest consecutive subsequence
	static int findLongestConseqSubseq(int arr[], int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		int ans = 0;

		// Hash all the array elements
		for (int i = 0; i < n; ++i)
			set.add(arr[i]);

		// check each possible sequence from the start then update optimal length
		for (int i = 0; i < n; ++i) {
			// if current element is the starting element of a sequence
			if (!set.contains(arr[i] - 1)) {
				// Then check for next elements in the sequence
				int j = arr[i];
				while (set.contains(j))
					j++;

				// update optimal length if this length is more
				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
		int n = arr.length;
		System.out.println("Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr, n));
	}
}
