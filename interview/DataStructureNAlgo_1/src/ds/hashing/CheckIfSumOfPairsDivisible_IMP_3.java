package ds.hashing;

/*
Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.
Input: arr[] = {92, 75, 65, 48, 45, 35}, k = 10
Output: True
We can divide array into (92, 48), (75, 65) and (45, 35). Sum of all these pairs is a multiple of 10.
 */
import java.util.HashMap;

public class CheckIfSumOfPairsDivisible_IMP_3 {

	static boolean canPairs(int ar[], int k) {
		if (ar.length % 2 == 1)
			return false;

		HashMap<Integer, Integer> hm = new HashMap<>();

		// Count occurrences of all remainders
		for (int i = 0; i < ar.length; i++) {
			int rem = ar[i] % k;
			if (!hm.containsKey(rem)) {
				hm.put(rem, 0);
			}
			hm.put(rem, hm.get(rem) + 1);
		}
		// use freq[] to decide if given array can be divided in pairs
		for (int i = 0; i < ar.length; i++) {
			int rem = ar[i] % k;
			// If remainder with current element divides k into two halves.
			if (2 * rem == k) {
				// Then there must be even occurrences of such remainder
				if (hm.get(rem) % 2 == 1)
					return false;
			} else if (rem == 0) {
				// Then there must be even occurrences of such remainder
				if (hm.get(rem) % 2 == 1)
					return false;
			} else {
				// Else number of occurrences of remainder must be equal to number of
				// occurrences of k - remainder
				if (hm.get(k - rem) != hm.get(rem))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int arr[] = { 92, 75, 65, 48, 45, 35 };
		int k = 10;
		boolean ans = canPairs(arr, k);
		if (ans)
			System.out.println("True");
		else
			System.out.println("False");

	}
}
