package ds.bst;

/*
 * Given a Binary Search Tree (BST) and a range, count the number of nodes in the BST that lie in the given range. You are required to complete the function getCountOfNode
 */
public class CountElementInRange_IMP_3 {

	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;

	CountElementInRange_IMP_3() {
		root = null;
	}

	// Returns count of nodes in BST in range [low, high]
	int getCount(Node node, int low, int high) {
		if (node == null)
			return 0;

		// If current node is in range, then include it in count and recur for
		// left and right children of it
		if (node.data >= low && node.data <= high)
			return 1 + this.getCount(node.left, low, high) + this.getCount(node.right, low, high);

		// If current node is smaller than low, then recur for right child
		else if (node.data < low)
			return this.getCount(node.right, low, high);
		// Else recur for left child
		else
			return this.getCount(node.left, low, high);
	}

	public static void main(String[] args) {

		CountElementInRange_IMP_3 tree = new CountElementInRange_IMP_3();

		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(50);
		tree.root.left.left = new Node(1);
		tree.root.right.left = new Node(40);
		tree.root.right.right = new Node(100);

		int l = 5;
		int h = 45;
		System.out.println("Count of nodes between [" + l + ", " + h + "] is " + tree.getCount(tree.root, l, h));
	}
}
