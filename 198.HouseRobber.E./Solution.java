import java.util.Arrays;

public class Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] map = new int[nums.length];
    Arrays.fill(map, -1);

    return findMaxRob(nums, 0, map);
  }

  public int findMaxRob(int[] nums, int start, int[] map) {
    if (map[start] != -1) {
      return map[start];
    }

    if (start == nums.length - 1) {
      map[start] = nums[start];
      return nums[start];
    }

    if (start == nums.length - 2) {
      map[start] = Math.max(nums[start], nums[start + 1]);
      return Math.max(nums[start], nums[start + 1]);
    }

    if (start == nums.length - 3) {
      map[start] = Math.max(nums[start] + nums[start + 2], nums[start + 1]);
      return Math.max(nums[start] + nums[start + 2], nums[start + 1]);
    }

    int firstCase = nums[start] + findMaxRob(nums, start + 2, map);
    int secondCase = nums[start + 1] + findMaxRob(nums, start + 3, map);
    map[start] = Math.max(firstCase, secondCase);
    return Math.max(firstCase, secondCase);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.rob(new int[] {}));
  }
}
