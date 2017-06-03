public class Solution {
  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    char[] charArr = s.toCharArray();

    int len = 0;
    boolean wordFound = false;
    for (int i = charArr.length - 1; i >= 0; i -= 1) {
      if (charArr[i] == ' ') {
        if (!wordFound) {
          continue;
        } else {
          break;
        }
      } else {
        len += 1;
        if (!wordFound) {
          wordFound = true;
        }
      }
    }

    return len;
  }

  public static void main(String [] args) {
    Solution s = new Solution();
    System.out.println(s.lengthOfLastWord("a "));
  }
}
