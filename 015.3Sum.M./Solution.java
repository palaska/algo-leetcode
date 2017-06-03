import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> result = new LinkedList<>();

    int len = nums.length;
    for (int i = 0; i < len - 2; i += 1) {
      if (i == 0 || (nums[i] != nums[i - 1])) { // find the first non-duplicate #
        int first = nums[i];
        int lowIndex = i + 1;
        int highIndex = len - 1;

        while(lowIndex < highIndex) {
          int low = nums[lowIndex];
          int high = nums[highIndex];

          if (first + low + high < 0) { lowIndex++; }
          if (first + low + high > 0) { highIndex--; }
          if (first + low + high == 0) {
            result.add(Arrays.asList(first, low, high));
            while(lowIndex < highIndex && nums[lowIndex] == low) { lowIndex++; }
            while(lowIndex < highIndex && nums[highIndex] == high) { highIndex--; }
          }
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
  }
}
