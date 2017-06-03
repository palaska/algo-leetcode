public class Solution {
  public String longestPalindrome(String s) {
    // we iterate through every index, check if its palindrome or not

    if (s.length() < 2) {
      return s;
    }

    char[] cs = s.toCharArray();
    int maxLen = 1;
    int startIndex = 0;

    int i = (cs.length - 1) / 2;
    int j = i + 1;
    boolean ignoreI = false;
    boolean ignoreJ = false;

    int temp[] = new int[2];

    while (i >= 0 || j < cs.length) {
      if (i >= 0 && !ignoreI) {
        temp = getDataAndUpdate(cs, i, maxLen, startIndex);
        startIndex = temp[0];
        maxLen = temp[1];
        i--;
      }

      if (j < cs.length && !ignoreJ) {
        temp = getDataAndUpdate(cs, j, maxLen, startIndex);
        startIndex = temp[0];
        maxLen = temp[1];
        j++;
      }

      ignoreI = (2 * (i + 1)) <= maxLen;
      ignoreJ = (cs.length - 1 - j) * 2 + 1 <= maxLen;

      if (ignoreI && ignoreJ) {
        break;
      }
    }

    return s.substring(startIndex, maxLen + startIndex);
  }

  private int[] getDataAndUpdate(char[] cs, int index, int maxLen, int startIndex) {
    int[] newData = checkPalindrome(cs, index, index);
    int[] newData2 = checkPalindrome(cs, index, index + 1);

    if (newData[1] > maxLen) {
      maxLen = newData[1];
      startIndex = newData[0];
    }

    if (newData2[1] > maxLen) {
      maxLen = newData2[1];
      startIndex = newData2[0];
    }

    return new int[] { startIndex, maxLen };
  }


  private int[] checkPalindrome(char[] cs, int j, int k) { // returns [startIndex, length]
    int len = 0;
    if (j == k) {
      len = -1;
    }

    while (j >= 0 && k < cs.length) {
      if (cs[j] == cs[k]) {
        len += 2;
        j--;
        k++;
      } else {
        break;
      }
    }

    return new int[] { j + 1, len }; // {startIndex, length}
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.longestPalindrome("babad"));
  }
}
