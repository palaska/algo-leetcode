import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return Arrays.asList();
    }

    List<List<Integer>> list = new LinkedList<List<Integer>>();
    list.add(Arrays.asList(root.val));
    list = pushChildrenToIndex(list, root, 1);
    return list;
  }

  public List<List<Integer>> pushChildrenToIndex(List<List<Integer>> list, TreeNode root, int index) {
    if (root.left == null && root.right == null) {
      return list;
    }

    if (list.size() <= index) {
      list.add(new LinkedList<Integer>());
    }

    if (root.left != null) {
      list.get(index).add(root.left.val);
      list = pushChildrenToIndex(list, root.left, index + 1);
    }

    if (root.right != null) {
      list.get(index).add(root.right.val);
      list = pushChildrenToIndex(list, root.right, index + 1);
    }

    return list;
  }

  public static void main(String[] args) {
    // TODO
  }
}
