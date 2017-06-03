public class Solution {
  // better solution
  public static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int p1 = 0;
    int prev = nums[0];

    for (int p2 = 1; p2 < nums.length; p2 += 1) {
      if (nums[p2] != prev) {
        prev = nums[p2];
        p1 += 1;
        nums[p1] = prev;
      }
    }

    return p1 + 1;
  }

  // after a swap, checking the same elements is unnecessary, must remind the index
  /*
  Input: sorted array

  Conditions
  - must be inplace
  - constant memory
  */
  /*
  public static int removeDuplicates(int[] nums) {

    if (nums == null || nums.length == 0) {
      return 0;
    }

    int length = 1;
    int max = nums[nums.length - 1];

    for (int i = 0; i < nums.length - 1; i += 1) {
      boolean isLast = false;
      for (int j = i + 1; j < nums.length; j += 1) {
        if (nums[i] >= nums[j]) {
          continue;
        } else {
          swap(nums, i + 1, j);
          length += 1;

          if (nums[i + 1] == max) {
            return length;
          }

          break;
        }
      }
    }

    return length;
  }

  public static void swap(int[] arr, int i1, int i2) {
    int temp = arr[i1];
    arr[i1] = arr[i2];
    arr[i2] = temp;
  }

  */

  public static void main(String[] args) {
    System.out.println(removeDuplicates(new int[] {1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 7, 7, 7, 7}));
  }
}
