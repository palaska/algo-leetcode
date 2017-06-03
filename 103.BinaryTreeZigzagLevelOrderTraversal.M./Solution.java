import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Solution {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Arrays.asList();
    }

    List<List<Integer>> list = new LinkedList<List<Integer>>();
    levelOrder(list, root, 0);
    for (int i = 0; i < list.size(); i += 1) {
      if (i % 2 == 1) {
        Collections.reverse(list.get(i));
      }
    }

    return list;
  }

  public void levelOrder(List<List<Integer>> list, TreeNode root, int index) {
    if (root != null) {
      if (list.size() == index) {
        list.add(new LinkedList<Integer>());
      }

      list.get(index).add(root.val);

      levelOrder(list, root.left, index + 1);
      levelOrder(list, root.right, index + 1);
    }
  }

  public static void main(String[] args) {
    // TODO
  }
}
