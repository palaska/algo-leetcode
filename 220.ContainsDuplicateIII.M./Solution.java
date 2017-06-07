import java.util.Arrays;
import java.math.BigInteger;
import java.util.Comparator;

public class Solution {
  public class Node {
    public int i;
    public BigInteger v;

    public Node(int i, BigInteger v) {
      this.i = i;
      this.v = v;
    }
  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    Node[] arr = new Node[nums.length];

    for (int i = 0; i < nums.length; i += 1) {
      arr[i] = new Node(i, new BigInteger(Integer.toString(nums[i])));
    }

    Arrays.sort(arr, new Comparator<Node>() {
      @Override
      public int compare(Node n1, Node n2) {
        int vv = n1.v.compareTo(n2.v);
        if (vv != 0) {
          return vv;
        }

        return n1.i - n2.i;
      }
    });

    for (int i = 0; i < arr.length - 1; i += 1) {
      for (int j = i + 1; j < arr.length; j += 1) {
        BigInteger valueDiff = arr[j].v.subtract(arr[i].v);
        BigInteger tt = new BigInteger(Integer.toString(t));
        if (valueDiff.compareTo(tt) == 1) {
          break;
        }

        if (Math.abs(arr[j].i - arr[i].i) <= k) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.containsNearbyAlmostDuplicate(new int[] { 0,10,22,15,0,5,22,12,1,5 }, 3, 3)); // false
    // System.out.println(s.containsNearbyAlmostDuplicate(new int[] { 1, 3, 5, 7, 18, 8}, 2, 1)); // true
    // System.out.println(s.containsNearbyAlmostDuplicate(new int[] { 1, 3, 5, 7, 18, 8}, 1, 1)); // false
  }
}
