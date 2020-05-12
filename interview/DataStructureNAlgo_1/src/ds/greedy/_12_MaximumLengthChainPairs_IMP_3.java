package ds.greedy;

/*
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 *  A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Find the longest chain which can be formed from a given set of pairs.

Examples:

Input:  (5, 24), (39, 60), (15, 28), (27, 40), (50, 90)
Output: (5, 24), (27, 40), (50, 90)

Input:  (11, 20), {10, 40), (45, 60), (39, 40)
Output: (11, 20), (39, 40), (45, 60) 

 */
public class _12_MaximumLengthChainPairs_IMP_3 {
	int a;
	int b;

	public _12_MaximumLengthChainPairs_IMP_3(int a, int b) {
		this.a = a;
		this.b = b;
	}

	// IMPORTANT: This function assumes that arr[] is sorted in increasing order
	// according the first (or smaller) values in pairs.
	static int maxChainLength(_12_MaximumLengthChainPairs_IMP_3 arr[], int n) {
		int i, j, max = 0;
		int mcl[] = new int[n];

		/* Initialize MCL (max chain length) values for all indexes */
		for (i = 0; i < n; i++)
			mcl[i] = 1;

		/* TODO Compute optimized chain length values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i].a > arr[j].b && mcl[i] < mcl[j] + 1)
					// mcl[i] now stores the maximum chain length ending with pair i
					mcl[i] = mcl[j] + 1;

		for (i = 0; i < n; i++)
			if (max < mcl[i])
				max = mcl[i];

		return max;
	}

	public static void main(String[] args) {
		_12_MaximumLengthChainPairs_IMP_3 arr[] = new _12_MaximumLengthChainPairs_IMP_3[] {
				new _12_MaximumLengthChainPairs_IMP_3(5, 24), new _12_MaximumLengthChainPairs_IMP_3(15, 25),
				new _12_MaximumLengthChainPairs_IMP_3(27, 40), new _12_MaximumLengthChainPairs_IMP_3(50, 60) };
		System.out.println("Length of maximum size chain is " + maxChainLength(arr, arr.length));
	}
}
