public class Solution {
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    nSum(nums, target, 0, 4);
  }

  // n is the number of elements to be used
  private static List<List<Integer>> nSum(int[] nums, int target, int startIndex, int n) {
    List<List<Integer>> list = new List<List<Integer>>();

    if (startIndex >= nums.length || n == 0) {
      return list;
    }

    if (n == 1) {
      for (int i = startIndex; i < nums.length; i += 1) {

      }
    }

    nSum(nums, target, startIndex + 1, n);
    nSum(nums, target - nums[startIndex], startIndex + 1, n - 1);
  }

  public static void main(String[] args) {
    // TODO
  }
}
