import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // create hashmap: { num, index}
    for (int i = 0; i < nums.length; i += 1) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i += 1) {
      int complement = target - nums[i];

      if (map.containsKey(complement) && i != map.get(complement)) {
        return new int[] { Math.min(map.get(complement), i), Math.max(map.get(complement), i) };
      }
    }

    return null;
  }

  public static void main(String[] args) {
    int[] myIntArray = {3, 2, 4};
    Solution mySolution = new Solution();
    System.out.println(Arrays.toString(mySolution.twoSum(myIntArray, 6)));
  }
}

// can do it in one loop, looking back to hashmap to see if it exists, inserting if not exists
