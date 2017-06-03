import java.util.Arrays;

public class Solution {
  public int[] plusOne(int[] digits) {
    if (digits.length == 0) {
      return new int[] {0};
    }

    if (digits.length == 1 && digits[0] == 0) {
      return new int[] {1};
    }

    for (int i = digits.length - 1; i >= 0; i -= 1) {
      if (digits[i] < 9) {
        digits[i] += 1;
        return digits;
      }

      digits[i] = 0;
    }

    int[] newDigits = new int[digits.length + 1];
    newDigits[0] = 1;
    return newDigits;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.plusOne(new int[] {9})));
  }
}
