package _com.interview.tree;

 //Definition for a binary tree node.
  class TreeNode {
     int val;
     TreeNode left;
  TreeNode right;
     TreeNode(int x) { val = x; }
  }

class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return left.val == right.val &&
                compare (left.left, right.right) &&
                compare (left.right, right.left);
    }
}