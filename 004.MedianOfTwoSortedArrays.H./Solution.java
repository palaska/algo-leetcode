public class Solution {
  // should be O(log (m+n))

  // nums1[0] ... nums1[i - 1] | nums1[i] ... nums1[m - 1]
  // nums2[0] ... nums2[j - 1] | nums2[j] ... nums2[n - 1]
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;

    if (m == 0) {
      if (n % 2 == 0) {
        return (nums2[n / 2] + nums2[(n / 2) - 1]) / 2.0;
      }

      return nums2[n / 2];
    }

    if (n == 0) {
      if (m % 2 == 0) {
        return (nums1[m / 2] + nums1[(m / 2) - 1]) / 2.0;
      }

      return nums1[m / 2];
    }

    if (m > n) {
      int[] tempArr = nums1;
      int tempInt = m;
      nums1 = nums2;
      nums2 = tempArr;
      m = n;
      n = tempInt;
    }

    boolean totalEven = false;

    if ((m + n) % 2 == 0) {
      totalEven = true;
    }
     // even
     // i + j = m - i + n - j
     //  j = (m + n)/2 - i

     // odd
     // i + j = m - i + n - j + 1
     //  j = (m + n + 1)/2 - i

    int imin = 0;
    int imax = m;
    int i = 0, j = 0;

    while (imin <= imax) {
      i = (imin + imax) / 2;
      j = (m + n + 1)/2 - i;

      // do tests
      if (i > 0 && nums1[i - 1] > nums2[j]) {
        imax = i - 1;
      } else if (i < m && nums2[j - 1] > nums1[i]) {
        imin = i + 1;
      } else {
        break;
      }
    }

    int maxOfLeft, minOfRight;
    if (i == 0) {
      maxOfLeft = nums2[j - 1];
    } else if (j == 0) {
      maxOfLeft = nums1[i - 1];
    } else {
      maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
    }

    if (i >= m) {
      minOfRight = nums2[j];
    } else if (j >= n) {
      minOfRight = nums1[i];
    } else {
      minOfRight = Math.min(nums1[i], nums2[j]);
    }


    if (totalEven) {
      return (maxOfLeft + minOfRight) / 2.0;
    }

    return maxOfLeft;
  }

  public static void main(String [] args) {
    Solution s = new Solution();

    System.out.println(s.findMedianSortedArrays(new int[] {}, new int[] {2, 3}));
  }
}
