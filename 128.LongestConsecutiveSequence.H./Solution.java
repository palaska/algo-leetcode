
import java.util.HashMap;

public class Solution {
  public int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> mem = new HashMap<Integer, Integer>(); // key is the number, value is the length of the corresponding sequence

    int max = 0;

    for (int i = 0; i < nums.length; i += 1) {
      if (mem.containsKey(nums[i])) {
        continue;
      }

      int left = mem.containsKey(nums[i] - 1) ? mem.get(nums[i] - 1) : 0;
      int right = mem.containsKey(nums[i] + 1) ? mem.get(nums[i] + 1) : 0;

      int sum = left + right + 1;

      mem.put(nums[i], sum);
      mem.put(nums[i] - left, sum);
      mem.put(nums[i] + right, sum);

      max = Math.max(max, sum);
    }

    return max;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.longestConsecutive(new int[] {1, 2, 0, 1}));
  }
}
