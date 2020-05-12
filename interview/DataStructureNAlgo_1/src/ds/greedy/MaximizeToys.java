package ds.greedy;

/**
 * Given an array consisting of cost of toys. Given an integer K depicting the amount of money available to purchase toys. 
 * Write a program to find the maximum number of toys one can buy with the amount K.

 Note: One can buy only 1 quantity of a particular toy.

 Examples :

 Input:  N = 10, K =  50
 cost = { 1, 12, 5, 111, 200, 1000, 10, 9, 12, 15 }
 Output: 6
 Explanation: Toys with amount 1, 5, 9, 10, 12, and 12 can be purchased resulting in a total amount of 49. Hence,
 maximum number of toys is 6.

 Input: N = 7, K = 50
 cost = { 1, 12, 5, 111, 200, 1000, 10 }
 Output: 4
 The idea to solve this problem is to first sort the cost array in ascending order. 
 This will arrange the toys in increasing order of the cost. 
 Now iterate over the cost array and keep calculating the sum of costs until the sum is less than or equal to K.
 Finally return the number of toys used to calculate the sum which is just less than or equals to K.

 Below is the implementation of above approach:
 */
import java.util.Arrays;

public class MaximizeToys {
	// This functions returns the required number of toys
	static int maximum_toys(int cost[], int N, int K) {
		int count = 0, sum = 0;
		// sort the cost array
		Arrays.sort(cost);
		for (int i = 0; i < N; i++) {
			// If the array element is less then K add it to prefix sum
			// and check this prefix sum is less then given K
			if (cost[i] < K && sum <= K) {
				sum = sum + cost[i];
				// Increment the count variable
				if (sum <= K)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int K = 50;
		int cost[] = { 1, 12, 5, 111, 200, 1000, 10, 9, 12, 15 };
		int N = cost.length;
		System.out.print(maximum_toys(cost, N, K));
	}
}
