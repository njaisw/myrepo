package ds.bst;

/*
 * Given a binary search tree and a target node K. The task is to find the node with minimum absolute difference with given target value K
 */

public class ClosestNeighbor_IMP_2 {

	static int min_diff, min_diff_key;

	static class Node {
		int data;
		Node left, right;
	};

	static Node newnode(int key) {

		Node node = new Node();
		node.data = key;
		node.left = node.right = null;
		return (node);
	}

//Function to find node with minimum absolute difference with given K min_diff -. minimum difference till now min_diff_key -. node having minimum absolute 	 difference with K 
	static void maxDiffUtil(Node root, int k) {
		if (root == null)
			return;
		// If k itself is present
		if (root.data == k) {
			min_diff_key = k;
			return;
		}

		// update min_diff and min_diff_key by checking current node value
		if (min_diff > Math.abs(root.data - k)) {
			min_diff = Math.abs(root.data - k);
			min_diff_key = root.data;
		}

		if (k < root.data)
			maxDiffUtil(root.left, k);
		else
			maxDiffUtil(root.right, k);
	}

	static int maxDiff(Node root, int k) {
		// Initialize minimum difference
		min_diff = 999999999;
		min_diff_key = -1;

		maxDiffUtil(root, k);

		return min_diff_key;
	}

	public static void main(String args[]) {

		Node root = newnode(9);
		root.left = newnode(4);
		root.right = newnode(17);
		root.left.left = newnode(3);
		root.left.right = newnode(6);
		root.left.right.left = newnode(5);
		root.left.right.right = newnode(7);
		root.right.right = newnode(22);
		root.right.right.left = newnode(20);
		int k = 18;
		System.out.println(maxDiff(root, k));

	}
}
