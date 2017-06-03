public class Solution {
  public boolean isPerfectSquare(int num) {
      if (num < 0) {
        return false;
      }

      if (num == 0 || num == 1) {
        return true;
      }

      if (num == 2 || num == 3) {
        return false;
      }

      long low = 1;
      long nums = (long) num;
      long high = nums;
      long mid = (low + high) / 2;

      while(low <= high) {
        mid = low + (high - low) / 2;

        if ((mid * mid) == nums)
            return true;
        else if((mid * mid) < nums)
            low = mid + 1;
        else
            high = mid - 1;
      }

      return false;
    }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.isPerfectSquare(64516));
  }
}
