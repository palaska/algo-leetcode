import java.util.Arrays;

public class Solution {

    // we could do this without using O(n) space, by starting the iteration from the end
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int[] nums1Copy = nums1.clone();
      int i = 0;
      int j = 0;

      for (int k = 0; k < m + n; k += 1) {
        if (i >= m) {
          nums1[k] = nums2[j];
          j += 1;
        } else if (j >= n) {
          nums1[k] = nums1Copy[i];
          i += 1;
        } else {
          if (nums1Copy[i] < nums2[j]) {
            nums1[k] = nums1Copy[i];
            i += 1;
          } else {
            nums1[k] = nums2[j];
            j += 1;
          }
        }
      }
    }

    public static void main(String[] args) {
      Solution s = new Solution();
      int[] a = new int[8];
      a[0] = 1;
      a[1] = 3;
      a[2] = 4;
      a[3] = 5;

      s.merge(a, 4, new int[] {2, 4, 5, 7}, 4);
      System.out.println(Arrays.toString(a));
    }
}
