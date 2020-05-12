package ds.stackNqueue;

//Java program to find celebrity using 
//stack data structure 

import java.util.Stack;

public class _14_CelebrityProblem_IMP_1 {
	static int MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

	// Returns true if a knows b, false otherwise
	static boolean knows(int a, int b) {
		boolean res = (MATRIX[a][b] == 1) ? true : false;
		return res;
	}

	// Returns -1 if celebrity is not present. If present, returns id (value from 0
	// to n-1).
	static int findCelebrity(int n) {
		Stack<Integer> stack = new Stack<>();
		int c;

		// Step 1 :Push everybody onto stack
		for (int i = 0; i < n; i++) {
			stack.push(i);
		}

		while (stack.size() > 1) {
			// Step 2 :Pop off top two persons from the stack, discard one person based on
			// return status of knows(A, B).
			int a = stack.pop();
			int b = stack.pop();

			// Step 3 : Push the remained person onto stack.
			if (knows(a, b)) {
				stack.push(b);
			} else
				stack.push(a);
		}

		c = stack.pop();

		// Step 5 : Check if the last person is celebrity or not
		for (int i = 0; i < n; i++) {
			// If any person doesn't know 'c' or 'c' know any person, return -1
			if (i != c && (knows(c, i) || !knows(i, c)))
				return -1;
		}
		return c;
	}

	public static void main(String[] args) {
		int n = 4;
		int result = findCelebrity(n);
		if (result == -1) {
			System.out.println("No Celebrity");
		} else
			System.out.println("Celebrity ID " + result);
	}
}