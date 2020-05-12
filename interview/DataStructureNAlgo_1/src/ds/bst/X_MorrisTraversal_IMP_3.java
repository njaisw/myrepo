package ds.bst;

/*
 * Using Morris Traversal, we can traverse the tree without using stack and recursion. 
 * The idea of Morris Traversal is based on Threaded Binary Tree. In this traversal, 
 * we first create links to Inorder successor and print the data using these links, and finally revert the changes to restore original tree.

1. Initialize current as root 
2. While current is not NULL
   If current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Make current as right child of the rightmost 
         node in current's left subtree
      b) Go to this left child, i.e., current = current->left

 */

class TNode { 
	int data; 
	TNode left, right; 

	TNode(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class X_MorrisTraversal_IMP_3 { 
	TNode root; 

	void MorrisPreOrderTraversal(TNode root) 
	{ 
		TNode current, pre; 
		if (root == null) 
			return; 

		current = root; 
		while (current != null) { 
			if (current.left == null) { 
				System.out.print(current.data + " "); 
				current = current.right; 
			} 
			else { 
				/* Find the inorder predecessor of current */
				pre = current.left; 
				while (pre.right != null && pre.right != current) 
					pre = pre.right; 

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) { 
					pre.right = current; 
					current = current.left; 
				} 

				/* Revert the changes made in if part to restore the 
					original tree i.e., fix the right child of predecssor*/
				else { 
					pre.right = null; 
					System.out.print(current.data + " "); 
					current = current.right; 
				} /* End of if condition pre->right == NULL */

			} /* End of if condition current->left == NULL*/

		} /* End of while */
	} 

	public static void main(String args[]) 
	{ 
		/* Constructed binary tree is 
			1 
			/ \ 
			2	 3 
		/ \ 
		4	 5 
		*/
		X_MorrisTraversal_IMP_3 tree = new X_MorrisTraversal_IMP_3(); 
		tree.root = new TNode(1); 
		tree.root.left = new TNode(2); 
		tree.root.right = new TNode(3); 
		tree.root.left.left = new TNode(4); 
		tree.root.left.right = new TNode(5); 

		tree.MorrisPreOrderTraversal(tree.root); 
	} 
} 
