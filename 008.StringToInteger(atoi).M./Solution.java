public class Solution {

  // test cases wtf

  public int myAtoi(String str) {
      str = str.trim();

      if (str.length() == 0) {
        return 0;
      }

      int multiplyWith = 1;

      if (str.charAt(0) == '+') {
          str = str.substring(1);
      }

      if (str.charAt(0) == '-') {
          multiplyWith = -1;
          str = str.substring(1);
      }

      if (str.indexOf('.') > -1) {
          str = str.substring(0, str.indexOf('.'));
      }


      str = str.trim();

      char[] cs = str.toCharArray();

      if (cs.length == 0) {
        return 0;
      }

      int digit = 1;
      int value = 0;
      for (int i = cs.length - 1; i >= 0; i -= 1) {
        if ((cs[i] - '0') < 0 || (cs[i] - '0') > 9) {
          return 0;
        }
        value += (cs[i] - '0') * digit;

        digit *= 10;
      }

      return multiplyWith * value;
    }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.myAtoi("-1234,234342"));
  }
}
