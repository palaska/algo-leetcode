public class Solution {
  public int removeElement(int[] nums, int val) {
    int t = 0;

    for (int i = 0; i < nums.length; i += 1) {
      if (nums[i] != val) {
        nums[t++] = nums[i];
      }
    }

    return t;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ss = s.removeElement(new int[] {1, 2, 3, 4, 5, 5, 4, 7, 8}, 4);
    System.out.println(ss);
  }
}
