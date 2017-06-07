import java.util.List;
import java.util.LinkedList;

public class Solution {
  // complexity is O(32n) ~ O(n)
  public int singleNumber(int[] nums) {
      int ans = 0;
      for(int i = 0; i < 32; i++) { // 32 bit integer
          int sum = 0;
          for(int j = 0; j < nums.length; j++) {
              if(((nums[j] >> i) & 1) == 1) { // bitshift operation
                  sum++;
                  sum %= 3;
              }
          }
          if(sum != 0) {
              ans |= sum << i;
          }
      }
      return ans;
  }

  // time limit exceeds
  /*
  public int singleNumber(int[] nums) {
    List<Integer> singles = new LinkedList<Integer>();
    List<Integer> doubles = new LinkedList<Integer>();

    for (int n: nums) {
      if (doubles.contains(n)) {
        continue;
      } else if (singles.contains(n)) {
        singles.remove(singles.indexOf(n));
        doubles.add(n);
      } else {
        singles.add(n);
      }
    }

    return singles.get(0);
  }
  */

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.singleNumber(new int[] {1, 2, 3, 1, 3, 2, 5, 1, 3, 2}));
  }
}
