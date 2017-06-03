public class Solution {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

      public String toString() {
        return this.val + ", " + this.left + ", " + this.right;
      }
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) {
      return new TreeNode();
    }

    int low = 0;
    int high = nums.length - 1;
    int mid = nums[(low + high) / 2];
    TreeNode head = createHeadAndChildren(nums, low, high);

    return head;
  }

  public TreeNode createHeadAndChildren(int[] nums, int low, int high) {
    if (low > high) {
      return null;
    }

    if (low == high - 1) {
      TreeNode result = new TreeNode(nums[low]);
      TreeNode right = new TreeNode(nums[high]);
      result.right = right;
      return result;
    }

    if (low == high) {
      TreeNode result = new TreeNode(nums[low]);
      return result;
    }

    int mid = (low + high) / 2;
    TreeNode head = new TreeNode(nums[mid]);
    head.left = createHeadAndChildren(nums, low, mid - 1);
    head.right = createHeadAndChildren(nums, mid + 1, high);
    return head;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 10}));
  }
}
