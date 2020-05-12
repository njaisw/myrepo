package ds.greedy;

/*
 * How to find the largest number with given digit sum s and number of digits d?
Input  : s = 9, d = 2
Output : 90

Input  : s = 20, d = 3
Output : 992

 */

public class _06_LargestNumberWithDigitsAndSum_IMP_2 {
	static void findLargest(int m, int s) {
		// If sum of digits is 0, then number is possible only if number of digits is 1
		if (s == 0) {
			System.out.print(m == 1 ? "Largest number is 0" : "Not possible");
			return;
		}
		// Sum greater than the maximum possible sum
		if (s > 9 * m) {
			System.out.println("Not possible");
			return;
		}
		// Create an array to store digits of result
		int[] res = new int[m];
		// Fill from most significant digit to least significant digit
		for (int i = 0; i < m; i++) {
			// Fill 9 first to make the number largest
			if (s >= 9) {
				res[i] = 9;
				s -= 9;
			} else {
				// If remaining sum becomes less than 9, then fill the remaining sum
				res[i] = s;
				s = 0;
			}
		}
		System.out.print("Largest number is ");
		for (int i = 0; i < m; i++)
			System.out.print(res[i]);
	}

	public static void main(String[] args) {
		int s = 9, m = 2;
		findLargest(m, s);
	}
}
