import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Solution {
  public static boolean isValid(String s) {
    Map<Character, Character> closingToOpening = new HashMap<Character, Character>();
    closingToOpening.put(')', '(');
    closingToOpening.put('}', '{');
    closingToOpening.put(']', '[');

    Stack<Character> stack = new Stack<Character>();
    char[] charArr = s.toCharArray();

    for (int i = 0; i < charArr.length; i += 1) {
      if (!closingToOpening.containsKey(charArr[i])) {
        stack.push(charArr[i]);
      } else {
        char correctOpening = closingToOpening.get(charArr[i]);
        if (stack.size() == 0 || stack.pop() != correctOpening) {
          return false;
        }
      }
    }

    if (stack.size() > 0) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isValid("()[]{}")); // valid
    System.out.println(isValid("()")); // valid
    System.out.println(isValid("(]")); // invalid
    System.out.println(isValid("([)]")); // invalid
  }
}
