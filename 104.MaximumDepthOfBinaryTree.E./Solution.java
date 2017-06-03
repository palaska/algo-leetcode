public class Solution {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  /*
  better solution
  public int maxDepth(TreeNode root) {
      if(root==null)
           return 0;
       return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
  }
  */

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + getMax(root.left, root.right);
  }

  public int getMax(TreeNode r1, TreeNode r2) {
    if (r1 == null && r2 == null) {
      return 0;
    }

    if (r1 == null && r2 != null) {
      return 1 + getMax(r2.left, r2.right);
    }

    if (r1 != null && r2 == null) {
      return 1 + getMax(r1.left, r1.right);
    }

    return 1 + Math.max(getMax(r1.left, r1.right), getMax(r2.left, r2.right));
  }

  public static void main(String[] args) {
    // TODO
  }
}
