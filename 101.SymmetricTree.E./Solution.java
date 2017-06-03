public class Solution {
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  // use stack for iterative solution

  // recursive
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isSym(root.left, root.right);
  }

  public boolean isSym(TreeNode rl, TreeNode rr) {
    if (rl == null && rr == null) {
      return true;
    }

    if (rl == null || rr == null) {
      return false;
    }

    return rl.val == rr.val && isSym(rl.left, rr.right) && isSym(rl.right, rr.left);
  }

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(3);
    TreeNode n2 = new TreeNode(3);
    TreeNode n3 = new TreeNode(4);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(2);
    TreeNode n6 = new TreeNode(2);
    TreeNode n7 = new TreeNode(1);
    n7.left = n6;
    n7.right = n5;
    n6.left = n1;
    n6.right = n3;
    n5.left = n2;
    n5.right = n4;
    Solution s = new Solution();
    System.out.println(s.isSymmetric(n7));
  }
}
