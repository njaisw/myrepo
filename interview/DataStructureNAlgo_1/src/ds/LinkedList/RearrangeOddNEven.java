package ds.LinkedList;

/*Given an array of integers, segregate even and odd numbers in the array. All the even numbers should be present first, and then the odd numbers.
Examples:
Input : 1 9 5 3 2 6 7 11
Output : 2 6 5 3 1 9 7 11

Input : 1 3 2 4 7 6 9 10
Output : 2 4 6 10 7 1 9 3

     The idea discussed in this post is based on Lomuto’s Partition Scheme
1: Maintain a pointer to the position before first odd element in the array. 2:Traverse the array and if even number is encountered then swap it with the first odd element.3:Continue the traversal.
*/
public class RearrangeOddNEven {

	static void arrayEvenAndOdd(int arr[], int n) {
		int i = -1, j = 0;
		while (j != n) {
			if (arr[j] % 2 == 0) {
				i++;

				// Swapping even and odd numbers
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			j++;
		}

		for (int k = 0; k < n; k++)
			System.out.print(arr[k] + " ");
	}

	public static void main(String args[]) {
		int arr[] = { 1, 3, 2, 4, 7, 6, 9, 10 };
		int n = arr.length;
		arrayEvenAndOdd(arr, n);
	}
}