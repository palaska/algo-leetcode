public class Solution {
  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }

    if (x == 1 || x == 2 || x == 3) {
      return 1;
    }

    int sq = x / 2;
    int step = sq / 2;
    while(step >= 1) {
      if (x/sq < sq) {
        sq = sq - step;
      } else if (x/(sq+1) >= (sq+1)) {
        sq = sq + step;
      } else {
        break;
      }

      step /= 2;
      if (step == 0) {
        step = 1;
      }
    }

    return sq;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.mySqrt(49));
  }
}
