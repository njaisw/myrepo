package ds.bst;

/*
 * Given an array, write a program that prints 1 if array represents Inorder traversal of a BST, else prints 0.  Note that all keys in BST must be unique.
 */
public class IfInOrderOrNot {

	static boolean isInorder(int[] arr, int n) {
		if (n == 0 || n == 1) {
			return true;
		}

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] > arr[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int arr[] = { 19, 23, 25, 30, 45 };
		int n = arr.length;
		if (isInorder(arr, n)) {
			System.out.println("Yes");
		} else {
			System.out.println("Non");
		}
	}
}
