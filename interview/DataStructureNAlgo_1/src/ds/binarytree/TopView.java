package ds.binarytree;

/*
 *    1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6

 */
import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class TopView {
	Node root;

	private void topviewNode(Node root) {
		class QueueObj {
			Node node;
			int hd;

			QueueObj(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

		if (root == null) {
			return;
		} else {
			q.add(new QueueObj(root, 0));
		}

		System.out.println("The top view of the tree is : ");

		// count function returns 1 if the container contains an element whose key is
		// equivalent to hd, or returns zero otherwise.
		while (!q.isEmpty()) {
			QueueObj tmpNode = q.poll();
			if (!topViewMap.containsKey(tmpNode.hd)) {
				topViewMap.put(tmpNode.hd, tmpNode.node);
			}

			if (tmpNode.node.left != null) {
				q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
			}
			if (tmpNode.node.right != null) {
				q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
			}

		}
		for (Entry<Integer, Node> entry : topViewMap.entrySet()) {
			System.out.print(entry.getValue().data);
		}
	}

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {

		TopView tree = new TopView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);
		System.out.println("Following are nodes in top view of Binary Tree");
		tree.topviewNode(tree.root);
	}

}
