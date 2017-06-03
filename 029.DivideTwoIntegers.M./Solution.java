public class Solution {
  public int divide(int dividend, int divisor) {
    int multiplyWith = 1;

    if (dividend == Integer.MIN_VALUE) {
      dividend = Integer.MAX_VALUE;
      multiplyWith *= -1;
    }

    if (dividend < 0) {
      dividend *= -1;
      multiplyWith *= -1;
    }

    if (divisor < 0) {
      divisor *= -1;
      multiplyWith *= -1;
    }

    if (divisor == 0) {
      return Integer.MAX_VALUE;
    }

    if (dividend == 0) {
      return 0;
    }

    String dd = Integer.toString(dividend);
    int result = 0;

    int i = 0;
    int j = 1;
    String rem = "";

    while(j <= dd.length()) {
      String currentDD = rem + dd.substring(i, j);
      while(Integer.parseInt(currentDD) < divisor && j < dd.length()) {
        j++;
        currentDD = rem + dd.substring(i, j);
      }

      if (Integer.parseInt(currentDD) >= divisor) {
        int k = 0;
        int kurrent = 0;
        while(kurrent < Integer.parseInt(currentDD)) {
          k++;
          kurrent += divisor;
        }

        if (kurrent > Integer.parseInt(currentDD)) {
          k--;
        }

        result = result * 10 + k;
        rem = Integer.toString(Integer.parseInt(currentDD) - (k * divisor));
        i = j;
        j = j + 1;
      } else {
        break;
      }
    }

    return result * multiplyWith;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.divide(210, 4));
  }
}
