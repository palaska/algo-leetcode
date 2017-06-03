public class Solution {
    // instead of recursion, we could use iteration
    public static int myBinarySearch(int[] nums, int target, int start, int end) {
      // check boundaries and mid
      if (target <= nums[start]) {
        return start;
      }

      if (target == nums[end]) {
        return end;
      }

      if (target > nums[end]) {
        return end + 1;
      }

      int mid = (start + end) / 2;
      if (target == nums[mid]) {
        return mid;
      }

      if (target < nums[mid]) {
        return myBinarySearch(nums, target, start + 1, mid - 1);
      }

      if (target > nums[mid]) {
        return myBinarySearch(nums, target, mid + 1, end - 1);
      }

      return 0;
    }

    public static int searchInsert(int[] nums, int target) {
      int start = 0;
      int end = nums.length - 1;
      return myBinarySearch(nums, target, start, end);
    }

    public static void main(String[] args) {
      int[] arr = {1, 3, 5, 6};
      System.out.println(searchInsert(arr, 5));
      System.out.println(searchInsert(arr, 2));
      System.out.println(searchInsert(arr, 7));
      System.out.println(searchInsert(arr, 0));
    }
}
