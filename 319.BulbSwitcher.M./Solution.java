import java.util.Arrays;

public class Solution {
  public int bulbSwitch(int n) {
    return (int) Math.sqrt(n);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.bulbSwitch(3));
  }

  // on 1 - 1
  // on off 2 - 1
  // on off off 3 - 1
  // on off off on 4 - 2
  // on off off on  off 5 - 2
  // on off off on  off off 6 - 2
  // on off off on  off off off 7 - 2
  // on off off on  off off off off 8 - 2
  // on off off on  off off off off on 9 - 3
}
