public class Solution {
  public int hammingDistance(int x, int y) {
    int diff = x ^ y;

    int cnt = 0;
    while (diff != 0) {
      diff &= (diff - 1);
      cnt += 1;
    }

    return cnt;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.hammingDistance(1, 4));
  }
}
