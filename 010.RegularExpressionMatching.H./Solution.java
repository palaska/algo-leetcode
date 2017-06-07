import java.util.HashMap;

public class Solution {
  HashMap<String, HashMap<String, Boolean>> map = new HashMap<>();
  public boolean isMatch(String s, String p) {
    // p can contain 3 different char types: . * x
    boolean containsS = map.containsKey(s);
    if (containsS && map.get(s).containsKey(p)) {
      return map.get(s).get(p);
    }

    if (!containsS) {
      map.put(s, new HashMap<>());
    }

    if (p == null || p.length() == 0) {
      return s == null || s.length() == 0;
    }

    if (p.length() > 1 && p.charAt(1) == '*') {
      boolean c1 = isMatch(s, p.substring(2)); // the beginning of string is irrelevant, x* represents empty string
      boolean c2 = s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p);
      map.get(s).put(p, c1 || c2);
      return c1 || c2;
    }

    return s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
  }
}
