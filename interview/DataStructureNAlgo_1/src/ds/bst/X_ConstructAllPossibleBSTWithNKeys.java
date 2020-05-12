package ds.bst;

//A Java prgroam to contrcut all unique BSTs for keys from 1 to n 
import java.util.ArrayList;

public class X_ConstructAllPossibleBSTWithNKeys {

	static ArrayList<Node> constructTrees(int start, int end) {
		ArrayList<Node> list = new ArrayList<>();
		/*
		 * if start > end then subtree will be empty so returning NULL in the list
		 */
		if (start > end) {
			list.add(null);
			return list;
		}

		/*
		 * iterating through all values from start to end for constructing\ left and
		 * right subtree recursively
		 */
		for (int i = start; i <= end; i++) {
			/* constructing left subtree */
			ArrayList<Node> leftSubtree = constructTrees(start, i - 1);

			/* constructing right subtree */
			ArrayList<Node> rightSubtree = constructTrees(i + 1, end);

			/*
			 * now looping through all left and right subtrees and connecting them to ith
			 * root below
			 */
			for (int j = 0; j < leftSubtree.size(); j++) {
				Node left = leftSubtree.get(j);
				for (int k = 0; k < rightSubtree.size(); k++) {
					Node right = rightSubtree.get(k);
					Node node = new Node(i);
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}
		return list;
	}

	static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String args[]) {
		ArrayList<Node> totalTreesFrom1toN = constructTrees(1, 3);
		System.out.println("Preorder traversals of all constructed BSTs are ");
		for (int i = 0; i < totalTreesFrom1toN.size(); i++) {
			preorder(totalTreesFrom1toN.get(i));
			System.out.println();
		}
	}

	static class Node {
		int key;
		Node left, right;

		Node(int data) {
			this.key = data;
			left = right = null;
		}
	};
}
