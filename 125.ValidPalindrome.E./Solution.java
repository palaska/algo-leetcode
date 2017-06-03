import java.util.List;
import java.util.LinkedList;

public class Solution {
  public boolean isPalindrome(String s) {
    s = s.toLowerCase();
    char[] sc = s.toCharArray();

    int l = 0;
    int h = sc.length - 1;

    while(l < h) {

      while (!isAlphanumeric(sc[l]) && l < h) {
        l++;
      }

      while (!isAlphanumeric(sc[h]) && h > l) {
        h--;
      }

      if (sc[l] != sc[h]) {
        return false;
      }

      l++;
      h--;
    }

    return true;
  }

  private boolean isAlphanumeric(char x) {
    return (x >= 48 && x <= 57) || (x >= 97 && x <= 122);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.isPalindrome("b"));
  }
}
