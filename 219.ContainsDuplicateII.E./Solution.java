import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public class Node {
    int prevIndex;
    int value;

    public Node(int prevIndex, int value) {
      this.prevIndex = prevIndex;
      this.value = value;
    }

    public String toString() {
      return "prevIndex: " + this.prevIndex + " | value: " + this.value;
    }
  }

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Node[] arr = new Node[nums.length];

    for (int i = 0; i < nums.length; i += 1) { // building Node array
      arr[i] = new Node(i, nums[i]);
    }

    Arrays.sort(arr, new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
          int v = o1.value - o2.value;
          if (v != 0) {
            return v;
          }

          return o1.prevIndex - o2.prevIndex;
        }
    });

    for (int i = 0; i < arr.length - 1; i += 1) {
      if (arr[i].value == arr[i + 1].value &&  Math.abs(arr[i].prevIndex - arr[i + 1].prevIndex) <= k) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.containsNearbyDuplicate(new int[] { 2, 1, 4, 3 }, 0)); // false
    System.out.println(s.containsNearbyDuplicate(new int[] { 2, 1, 4, 3 }, 1)); // false
    System.out.println(s.containsNearbyDuplicate(new int[] { 2, 1, 4, 5, 4}, 2)); // true
    System.out.println(s.containsNearbyDuplicate(new int[] { 2, 1, 4, 5, 4}, 3)); // true
    System.out.println(s.containsNearbyDuplicate(new int[] { 2, 1, 4, 5, 4}, 1)); // false
  }
}
