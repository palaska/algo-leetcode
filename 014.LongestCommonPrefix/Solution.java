public class Solution {
  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }

    int commonCnt = strs[0].length();
    char[] first = strs[0].toCharArray();
    for (int i = 1; i < strs.length; i += 1) {
      char[] current = strs[i].toCharArray();
      int currentCommonCnt = 0;
      for (int j = 0; j < Math.min(commonCnt, current.length); j += 1) {
        if (current[j] == first[j]) {
          currentCommonCnt += 1;
        } else {
          break;
        }
      }

      commonCnt = Math.min(currentCommonCnt, commonCnt);
    }

    return strs[0].substring(0, commonCnt);
  }

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String[] {"mustafa", "musa", "mutfak", "muasdfasdf", "musti"}));
  }
}
