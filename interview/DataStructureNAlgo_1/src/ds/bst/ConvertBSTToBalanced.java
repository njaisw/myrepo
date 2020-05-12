package ds.bst;

/*
 * Given a BST (Binary Search Tree) that may be unbalanced, convert it into a balanced BST that has minimum possible height.
          4
        /   \
       3     5
      /       \
     2         6 
    /           \
   1             7
Output:
       4
    /    \
   2      6
 /  \    /  \
1    3  5    7 
An Efficient Solution can construct balanced BST in O(n) time with minimum possible height. Below are steps.
1.	Traverse given BST in inorder and store result in an array. This step takes O(n) time. 
Note that this array would be sorted as inorder traversal of BST always produces sorted sequence.
2.	Build a balanced BST from the above created sorted array using the recursive approach discussed here. 
This step also takes O(n) time as we traverse every element exactly once and processing an element takes O(1) time.

 */

import java.util.*;

public class ConvertBSTToBalanced {
	Node root;

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	/*
	 * This function traverse the skewed binary tree and stores its nodes pointers
	 * in vector nodes[]
	 */
	void storeBSTNodes(Node root, Vector<Node> nodes) {

		if (root == null)
			return;

		// Store nodes in Inorder (which is sorted order for BST)
		storeBSTNodes(root.left, nodes);
		nodes.add(root);
		storeBSTNodes(root.right, nodes);
	}

	/* Recursive function to construct binary tree */
	Node buildTreeUtil(Vector<Node> nodes, int start, int end) {
		if (start > end)
			return null;

		int mid = (start + end) / 2;
		Node node = nodes.get(mid);

		node.left = buildTreeUtil(nodes, start, mid - 1);
		node.right = buildTreeUtil(nodes, mid + 1, end);

		return node;
	}

	Node buildTree(Node root) {
		Vector<Node> nodes = new Vector<Node>();
		storeBSTNodes(root, nodes);
		int n = nodes.size();
		return buildTreeUtil(nodes, 0, n - 1);
	}

	void preOrder(Node node) {
		if (node == null)
			return;
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {

		ConvertBSTToBalanced tree = new ConvertBSTToBalanced();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(7);
		tree.root.left.left.left = new Node(6);
		tree.root.left.left.left.left = new Node(5);

		tree.root = tree.buildTree(tree.root);
		System.out.println("Preorder traversal of balanced BST is :");
		tree.preOrder(tree.root);
	}
}
