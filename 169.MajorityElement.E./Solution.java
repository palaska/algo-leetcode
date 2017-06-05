import java.util.HashMap;

public class Solution {
  /*
  MORE ELEGANT SOLUTION WITH NO EXTRA SPACE
  public int majorityElement(int[] nums) {
      int res = nums[0];
      int cnt = 1;
      for (int i=1; i<nums.length; i++) {
          if (cnt == 0) res = nums[i];
          if (nums[i] != res) cnt--;
          else cnt++;
      }
      return res;
  }
  */

  public int majorityElement(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int max = 0;
    int elem = 0;

    for (int i = 0; i < nums.length; i += 1) {
      int current = 0;
      if (!map.containsKey(nums[i])) {
        current = 1;
      } else {
        current = map.get(nums[i]) + 1;
      }

      map.put(nums[i], current);
      if (current > max) {
        max = current;
        elem = nums[i];
      }
    }

    return elem;
  }

  public static void main(String[] args) {
    // TODO
  }
}
