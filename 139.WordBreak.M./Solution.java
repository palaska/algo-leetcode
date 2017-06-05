import java.util.List;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    HashMap<Integer, Boolean> memory = new HashMap<>();
    return checkValid(0, s, wordDict, memory);
  }

  public boolean checkValid(int startIndex, String s, List<String> wordDict, HashMap<Integer, Boolean> memory) {
    if (memory.containsKey(startIndex)) {
      return memory.get(startIndex);
    }

    if (startIndex == s.length()) {
      return true;
    }

    for (int i = 0; i <= s.length() - startIndex; i += 1) {
      if (wordDict.contains(s.substring(startIndex, startIndex + i))) {
        if (checkValid(startIndex + i, s, wordDict, memory)) {
          memory.put(startIndex + i, true);
          return true;
        }

        memory.put(startIndex + i, false);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.wordBreak("leetcode", Arrays.asList("leet", "code")));
  }
}
