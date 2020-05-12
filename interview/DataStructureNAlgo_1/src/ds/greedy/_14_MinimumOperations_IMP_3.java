package ds.greedy;

//Java implementation to convert a number m to n using minimum number of given operations 

public class _14_MinimumOperations_IMP_3 {
	// function to find minimum number of given operations to convert m to n
	static int convert(int m, int n) {
		if (m == n)
			return 0;
		// only way is to do -1 (m - n) times
		if (m > n)
			return m - n;
		// not possible
		if (m <= 0 && n > 0)
			return -1;
		// n is greater and n is odd
		if (n % 2 == 1)
			//TODO perform '-1' on m (or +1 on n)
			return 1 + convert(m, n + 1);
		// n is even
		else
			// perform '*2' on m (or n / 2 on n)
			return 1 + convert(m, n / 2);
	}

	public static void main(String[] args) {
		int m = 3, n = 11;
		System.out.println("Minimum number of " + "operations : " + convert(m, n));
	}
}
