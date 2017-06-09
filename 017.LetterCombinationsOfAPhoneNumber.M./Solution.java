import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
  public List<String> letterCombinations(String digits) {
    char[][] map = new char[][] {
      {}, {},
      {'a', 'b', 'c'},
      {'d', 'e', 'f'},
      {'g', 'h', 'i'},
      {'j', 'k', 'l'},
      {'m', 'n', 'o'},
      {'p', 'q', 'r', 's'},
      {'t', 'u', 'v'},
      {'w', 'x', 'y', 'z'}
    };

    char[] dc = digits.toCharArray();
    List<String> result = new ArrayList<String>();

    for (int k = 0; k < dc.length; k += 1) {
      char d = dc[k];
      char[] chars = map[Character.getNumericValue(d)];

      int size = result.size();
      for (int i = 0; i < chars.length; i += 1) {
        if (k == 0) {
          result.add(chars[i] + "");
        } else {
          for (int j = 0; j < size; j += 1) {
            if (i == 0) {
              result.set(j, result.get(j) + chars[i]);
            } else {
              String s = result.get(j);
              s = s.substring(0, s.length() - 1);
              result.add(s + chars[i]);
            }
          }
        }
      }
    }

    return result;
  }

  /*
  USE A QUEUE! (FIFO)
  start with empty queue,
  iteration # - queue
  1             a, b, c
  2             ad, ae, af, bd, be, bf, cd, ce, cf
  for(int i = 0; i < inputLength; i++)
  trick is, while(queue.peek().length() == i)
  ...
  */
  /*
  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return Arrays.asList();
    }

    HashMap<Character, List<String>> map = new HashMap<>();
    map.put('2', Arrays.asList("a", "b", "c"));
    map.put('3', Arrays.asList("d", "e", "f"));
    map.put('4', Arrays.asList("g", "h", "i"));
    map.put('5', Arrays.asList("j", "k", "l"));
    map.put('6', Arrays.asList("m", "n", "o"));
    map.put('7', Arrays.asList("p", "q", "r", "s"));
    map.put('8', Arrays.asList("t", "u", "v"));
    map.put('9', Arrays.asList("w", "x", "y", "z"));

    char[] charDigits = digits.toCharArray();

    int size = 1;
    for (int i = 0; i < charDigits.length; i += 1) {
      if (!map.containsKey(charDigits[i])) {
        return Arrays.asList();
      }

      size *= map.get(charDigits[i]).size();
    }

    List<String> res = new ArrayList<String>(Collections.nCopies(size, ""));

    int blockSize = size;
    for (int i = 0; i < charDigits.length; i += 1) { // 2, 7, 3
      int charCnt = map.get(charDigits[i]).size();
      blockSize /= charCnt;

      int j = 0;
      while(j < size) {
        String letter = map.get(charDigits[i]).get((j / blockSize) % charCnt);
        res.set(j, res.get(j) + letter);
        j++;
      }
    }

    return res;
  }
  */

  // adf
  // adg
  // aef
  // aeg
  // bdf
  // bdg
  // bef
  // beg
  // cdf
  // cdg
  // cef
  // ceg


  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.letterCombinations("273"));
  }
}
