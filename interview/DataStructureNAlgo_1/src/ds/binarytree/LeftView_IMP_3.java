package ds.binarytree;

/*
 Input : 
 1
 /   \
 2     3
 / \     \
 4   5     6             
 Output : 1 2 4

 Input :
 1
 /   \
 2       3
 \   
 4  
 \
 5
 \
 6
 Output :1 2 4 5 6
 */
class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class LeftView_IMP_3 {
	Node root;
	static int max_level = 0;

	void leftViewUtil(Node node, int level) {

		if (node == null) {
			System.out.println("null");
			return;
		}

		// If this is the first node of its level
		if (max_level < level) {

			System.out.print(" data " + node.data + "\n");
			max_level = level;
		}

		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}

	void leftView() {
		leftViewUtil(root, 1);
	}

	public static void main(String args[]) {
		LeftView_IMP_3 tree = new LeftView_IMP_3();
		tree.root = new Node(12);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);
		tree.leftView();
	}
}
