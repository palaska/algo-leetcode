public class Solution {
    public static int strStr(String haystack, String needle) {
      // brute force
      char[] hs = haystack.toCharArray();
      char[] ne = needle.toCharArray();

      // iterate over haystack characters
      for (int i = 0; i < hs.length - (ne.length - 1); i += 1) {
        // iterate over needle characters
        boolean found = true;
        for (int j = 0; j < ne.length; j += 1) {
          if (hs[i + j] != ne[j]) {
            found = false;
          }
        }

        if (found) {
          return i;
        }
      }

      return -1;
    }

    public static void main(String[] args) {
      System.out.println(strStr("bababababab", "aba"));
      System.out.println(strStr("helal olsun pascal nouma", " pasc"));
      System.out.println(strStr("helal olsun pascal nouma", "pasa"));
    }
}
