package ds.sorting.searching;

//Java program to count buildings that can 
//see sunlight. 

/*Given an array representing heights of buildings. 
The array has buildings from left to right as shown in below diagram, count number of buildings facing the sunset. It is assumed that heights of all buildings are distinct.

Input : arr[] = {7, 4, 8, 2, 9}
Output: 3
Explanation: As 7 is the first element, it can sunset.
4 can't see the sunset as 7 is hiding it. 8 can see. 2 can't see the sunset. 9 also can see the sunset.

*/
public class _16_FacingTheSun {
	static int countBuildings(int arr[], int n) {
		int count = 1;
		// Start traversing element
		int curr_max = arr[0];
		for (int i = 1; i < n; i++) {
			// If curr_element is maximum, update maximum and increment count
			if (arr[i] > curr_max) {
				count++;
				curr_max = arr[i];
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 7, 4, 8, 2, 9 };
		System.out.println(countBuildings(arr, arr.length));

	}
}
