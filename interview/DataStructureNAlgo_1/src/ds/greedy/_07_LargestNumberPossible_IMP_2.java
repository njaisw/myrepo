package ds.greedy;

/**
 * Given an array of numbers, arrange them in a way that yields the largest value. 
 * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. 
 * And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
 */
import java.util.*;

public class _07_LargestNumberPossible_IMP_2 {

	// The main function that prints the arrangement with the largest value.
	static void printLargest(List<String> arr) {
		Collections.sort(arr, new Comparator<String>() {

			@Override
			// @return a negative integer, zero, or a positive integer as the
			// first argument is less than, equal to, or greater than the
			// second.
			public int compare(String X, String Y) {

				// first append Y at the end of X
				String XY = X + Y;

				// then append X at the end of Y
				String YX = Y + X;

				// Now see which of the two formed numbers is greater
				// 0 if the strings are equal,
				// a negative integer if this X is before the specified String or Y
				// or a positive integer if this String or X is after the specified String Y
				System.out.println(XY + " " + YX + " " + XY.compareTo(YX));
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		Iterator it = arr.iterator();

		while (it.hasNext())
			System.out.print(it.next() + " ");

	}

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		printLargest(arr);

	}
}
