import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {
  public String minWindow(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();

    char[] tc = t.toCharArray();
    char[] sc = s.toCharArray();

    // building the hashmap: <character, occurance count>
    for (char tt: tc) { // going over every character in t
      if (map.containsKey(tt)) {
        map.put(tt, map.get(tt) + 1);
      } else {
        map.put(tt, 1);
      }
    }

    int minStart = 0;
    int minLength = Integer.MAX_VALUE;

    int start = 0; // start index
    int end = 0; // end index
    int counter = tc.length;

    while(end < sc.length) {
      if (map.containsKey(sc[end])) {
        int oc = map.get(sc[end]);
        if (oc > 0) {
          counter -= 1;
        }

        map.put(sc[end], oc - 1);
      }

      end += 1;

      while (counter == 0) {
        if (end - start < minLength) {
          minStart = start;
          minLength = end - start;
        }

        if (map.containsKey(sc[start])) {
          int ocs = map.get(sc[start]);
          map.put(sc[start], ocs + 1);

          if (ocs + 1 > 0) {
            counter += 1;
          }
        }

        start += 1;
      }
    }

    if (minLength != Integer.MAX_VALUE) {
      return s.substring(minStart, minStart + minLength);
    }

    return "";
  }


  // passes 267/268, time limit :(
  /*
  public String minWindow(String s, String t) {

    if (t == null || t == "") {
      return "";
    }

    HashMap<Character, ArrayList<Integer>> map = new HashMap<>(); // char, index
    HashMap<Character, Integer> occurances = new HashMap<>();

    // filling all character indices with -1 initially
    char[] tc = t.toCharArray();
    for (char tt: tc) {
      map.put(tt, new ArrayList<Integer>());

      if (!occurances.containsKey(tt)) {
        occurances.put(tt, 1);
      } else {
        occurances.put(tt, occurances.get(tt) + 1);
      }
    }

    char[] sc = s.toCharArray();

    int[] minWindowData = new int[] { Integer.MAX_VALUE, -1 }; // minWindowLength, minWindowEndIndex

    for (int i = 0; i < sc.length; i += 1) {
      if (map.containsKey(sc[i])) {
        ArrayList<Integer> indicesList = map.get(sc[i]);
        indicesList.add(i);

        map.put(sc[i], indicesList);

        int newWindowLength = calculateMinWindow(map, occurances, tc);
        if (newWindowLength < minWindowData[0]) {
          minWindowData[0] = newWindowLength; // setting new minWindowLength
          minWindowData[1] = i; // setting new end index
        }
      }
    }

    if (minWindowData[0] <= sc.length) {
      return s.substring(minWindowData[1] - minWindowData[0] + 1, minWindowData[1] + 1);
    }

    return "";
  }

  private int calculateMinWindow(HashMap<Character, ArrayList<Integer>> map, HashMap<Character, Integer> occurances, char[] tc) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (char tt: tc) {
      int oc = occurances.get(tt);
      ArrayList<Integer> indices = map.get(tt);

      if (indices.size() < oc) {
        return Integer.MAX_VALUE;
      }

      min = Math.min(min, indices.get(indices.size() - oc));
      max = Math.max(max, indices.get(indices.size() - 1));
    }

    return max - min + 1;
  }
  */

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
  }
}
