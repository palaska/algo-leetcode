public class Solution {
  // BRUTE FORCE
  // public char findTheDifference(String s, String t) {
  //   StringBuilder ss = new StringBuilder(s);

  //   for (int i = 0; i < t.length(); i += 1) {
  //     int index = ss.indexOf(Character.toString(t.charAt(i)));

  //     if (index == -1) {
  //       return t.charAt(i);
  //     }

  //     ss.deleteCharAt(index);
  //   }

  //   return 'a';
  // }

  // ELEGANT
  public char findTheDifference(String s, String t) {
    char[] sc = s.toCharArray();
    char[] tc = t.toCharArray();

    int xor = 0;
    for (int i = 0; i < sc.length + tc.length; i += 1) {
      if (i < sc.length) {
        xor ^= sc[i];
      } else {
        xor ^= tc[i - sc.length];
      }
    }

    return (char) xor;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findTheDifference("abcd", "abecd"));
  }
}
