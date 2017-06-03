public class Solution {
  public int singleNumber(int[] nums) {
    int n = 0;
    for (int num : nums) {
      n ^= num;
    }

    return n;
  }

  public static void main(String[] args) {
    // TODO
  }
}
