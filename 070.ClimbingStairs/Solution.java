public class Solution {
  public int climbStairs(int n) {
    int[] dict = new int[n + 5];
    dict[1] = 1;
    dict[2] = 2;

    return recurse(n, dict);
  }

  public int recurse(int n, int[] dict) {
    if (dict[n] > 0) {
      return dict[n];
    }

    int a = recurse(n - 1, dict);
    int b = recurse(n - 2, dict);

    dict[n] = a + b;
    return dict[n];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.climbStairs(1));
  }
}
