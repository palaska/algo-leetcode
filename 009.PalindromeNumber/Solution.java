public class Solution {
    public boolean isPalindrome(int x) {
      String str = Integer.toString(x);
      int len = str.length() / 2;

      for (int i = 0; i < len; i += 1) {
        if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
          return false;
        }
      }

      return true;
    }

    /*
    Better solution

    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
          rev = rev*10 + x%10;
          x = x/10;
        }
        return (x==rev || x==rev/10);
    }
    */

    public static void main(String[] args) {
      System.out.println(isPalindrome(535));
    }
}
