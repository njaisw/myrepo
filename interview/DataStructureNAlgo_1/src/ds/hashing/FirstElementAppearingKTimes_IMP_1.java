package ds.hashing;

import java.util.HashMap;

/*Given an array of n integers. The task is to find the first element that occurs k number of times. If no element occurs k times the print -1. The distribution of integer elements could be in any range.
Input : {1, 7, 4, 3, 4, 8, 7}, k = 2
Output : 7 Both 7 and 4 occur 2 times.But 7 is the first that occurs 2 times. 

Input : {4, 1, 6, 1, 6, 4}, k = 1
Output : -1
*/
//TODO index and cound both are stored in map
public class FirstElementAppearingKTimes_IMP_1 {

	static class Element {
		int firstIndex;
		int count;

		public Element(int index, int c) {
			this.firstIndex = index;
			this.count = c;
		}

		public Element incrementcount() {
			this.count++;
			return this;

		}

	}

	static int firstElement(int arr[], int n, int k) {
		HashMap<Integer, Element> count_map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			Element element = null;
			if (count_map.get(arr[i]) != null) {
				element = count_map.get(arr[i]);
			} else {
				element = new Element(i, 0);
			}
			count_map.put(arr[i], element.incrementcount());
		}
		// count_map[arr[i]]++;
		for (int i = 0; i < n; i++) { // if count of element == k ,then it is the required first element
			if (count_map.get(arr[i]).count == k) {
				return arr[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 7, 4, 3, 4, 8, 7 };
		int n = arr.length;
		int k = 2;
		System.out.println(firstElement(arr, n, k));
	}
}
