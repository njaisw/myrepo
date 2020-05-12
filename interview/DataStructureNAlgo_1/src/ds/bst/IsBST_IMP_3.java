package ds.bst;

//Java implementation to check if given Binary tree is a BST or not 

public class IsBST_IMP_3 {
	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;

	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isBSTUtil(Node root, int min, int max) {

		if (root == null)
			return true;

		if (root.data < min || root.data > max)
			return false;

		return (isBSTUtil(root.left, min, root.data - 1) && isBSTUtil(root.right, root.data + 1, max));
	}

	public static void main(String args[]) {
		IsBST_IMP_3 tree = new IsBST_IMP_3();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
}
