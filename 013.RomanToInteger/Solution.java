import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static int romanToInt(String s) {
      Map<Character, Integer> dict = new HashMap<Character, Integer>();
      dict.put('I', 1);
      dict.put('V', 5);
      dict.put('X', 10);
      dict.put('L', 50);
      dict.put('C', 100);
      dict.put('D', 500);
      dict.put('M', 1000);

      char[] charArr = s.toCharArray();
      char last = charArr[charArr.length - 1];
      int sum = dict.get(last);

      for (int i = 0; i < charArr.length - 1; i += 1) {
        int currentVal = dict.get(charArr[i]);
        if (currentVal < dict.get(charArr[i + 1])) {
          sum -= currentVal;
        } else {
          sum += currentVal;
        }
      }

      return sum;
    }

    public static void main(String[] args) {
      System.out.println(romanToInt("XLV"));
      System.out.println(romanToInt("XXI"));
      System.out.println(romanToInt("MDCC"));
    }
}
