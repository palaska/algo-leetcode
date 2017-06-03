import java.util.HashMap;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    char[] chars = s.toCharArray();

    int max = 0;
    int cnt = 0;
    for (int i = 0; i < chars.length; i += 1) {
      if (!map.containsKey(chars[i]) || map.get(chars[i]) < i - cnt) {
        cnt++;
        max = Math.max(max, cnt);
      } else {
        int lastIndex = map.get(chars[i]);
        cnt = i - lastIndex;
      }

      map.put(chars[i], i);
    }

    return max;
  }

  // 1, 2, 3, 2

  public static void main(String[] args) {
    Solution s = new Solution();
    // System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    // System.out.println(s.lengthOfLongestSubstring("bbbbbb"));
    // System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    System.out.println(s.lengthOfLongestSubstring("tmmzuxt"));
  }

  // t m m z u x t
  // 1 2 1 2 3 4
}
