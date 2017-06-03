public class Solution {
    public static int reverse(int x) {
      boolean isNegative = false;
      if (x < 0) {
        isNegative = true;
        x *= -1;
      }

      int rev = 0;

      while(x > 0) {
        int last = x % 10;
        int newRev = last + (rev * 10);

        // handles overflow
        if ((newRev - last) / 10 != rev) {
          return 0;
        }

        rev = newRev;
        x /= 10;
      }

      if (isNegative) {
        rev *= -1;
      }

      return rev;
    }

    public static void main(String[] args) {
      System.out.println(reverse(123));
    }
}
