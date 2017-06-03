import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Solution {
  public List<List<Integer>> generate(int numRows) {
    if (numRows == 0) {
      return Arrays.asList();
    }

    List<List<Integer>> result = new LinkedList<List<Integer>>();
    List<Integer> first = new LinkedList<Integer>();
    first.add(1);
    result.add(first);

    if (numRows == 1) {
      return result;
    }

    int i = 1;
    while (i < numRows) {
      List<Integer> prev = result.get(i - 1);
      List<Integer> fresh = new LinkedList<Integer>();
      fresh.add(1);
      for (int j = 0; j < prev.size() - 1; j += 1) {
        if (j == 0) {
          fresh.add(prev.get(1) + 1);
        } else if (j == prev.size() - 2) {
          fresh.add(prev.get(j) + 1);
        } else {
          fresh.add(prev.get(j) + prev.get(j + 1));
        }
      }

      fresh.add(1);
      result.add(fresh);
      i++;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.generate(5));
  }
}
