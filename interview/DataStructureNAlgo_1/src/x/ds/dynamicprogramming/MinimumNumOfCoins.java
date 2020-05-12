package x.ds.dynamicprogramming;

//A Dynamic Programming based Java 
//program to find minimum of coins 
//to make a given change V 

/*
 * Given a value N, total sum you have. 
 * You have to make change for Rs. N, and there is infinite supply of each of the denominations in Indian currency, i.e.,
 *  you have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000} valued coins/notes, 
 *  Find the minimum number of coins and/or notes needed to make the change for Rs N.
 */

public class MinimumNumOfCoins {
	// m is size of coins array
	// (number of different coins)
	static int minCoins(int coins[], int m, int V) {
		// table[i] will be storing the minimum number of coins required for i value. So table[V] will have result
		int table[] = new int[V + 1];

		// Base case (If given value V is 0)
		table[0] = 0;

		// Initialize all table values as Infinite
		for (int i = 1; i <= V; i++)
			table[i] = Integer.MAX_VALUE;

		// Compute minimum coins required for all
		// values from 1 to V
		for (int i = 1; i <= V; i++) {
			// Go through all coins smaller than i
			for (int j = 0; j < m; j++)
				if (coins[j] <= i) {
					int sub_res = table[i - coins[j]];
					if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
						table[i] = sub_res + 1;

				}

		}
		return table[V];

	}

	// Driver program
	public static void main(String[] args) {
		int coins[] = { 9, 6, 5, 1 };
		int m = coins.length;
		int V = 11;
		System.out
				.println("Minimum coins required is " + minCoins(coins, m, V));
	}
}

// This article is contributed by vt_m.

