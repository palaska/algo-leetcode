public class Solution {
  // O(n^2 / 2) - quadratic
  /*
  public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    for (int i = 0; i < nums.length - 1; i += 1) {
      for (int j = i + 1; j < nums.length; j += 1) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }

    return false;
  }
  */

  // O(nlgn) - linearithmic
  public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    Arrays.sort(nums); // linearithmic

    for (int i = 0; i < nums.length - 1; i += 1) { // linear
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.containsDuplicate(new int[] {1, 2, 3, 5, 7, 8, 9}));
    System.out.println(s.containsDuplicate(new int[] {1, 2, 3, 5, 7, 3, 9}));
  }
}
