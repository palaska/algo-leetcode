import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Solution {
  public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

      public String toString() {
        return "start: " + this.start + " | end: " + this.end;
      }
  }

  public List<Interval> merge(List<Interval> intervals) {
    ArrayList<Interval> ints = new ArrayList<>(intervals);

    Collections.sort(ints, new Comparator<Interval> () {
      @Override
      public int compare(Interval a, Interval b) {
        return a.end - b.end;
      }
    });

    for (int i = ints.size() - 1; i > 0; i -= 1) {
      Interval i1 = ints.get(i - 1);
      Interval i2 = ints.get(i);

      if (i1.end >= i2.start) {
        ints.set(i - 1, new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end)));
        ints.remove(i);
      }
    }

    return ints;
  }

  public static void main(String[] args) {
    Interval i1 = new Interval(2,3);
    Interval i2 = new Interval(4,5);
    Interval i3 = new Interval(6,7);
    Interval i4 = new Interval(8,9);
    Interval i5 = new Interval(1,10);

    Solution s = new Solution();
    System.out.println(s.merge(Arrays.asList(i1, i2, i3, i4, i5)));
  }
}
