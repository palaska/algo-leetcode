public class Solution {
  public int search(int[] nums, int target) {

    // NICE QUESTION, MEMORIZE

    if (nums.length == 0) {
      return -1;
    }

    int start = 0, end = nums.length - 1;
    while (start < end) {
      int mid = (start + end) / 2;

      if (nums[mid] > nums[end]) {  // eg. 3,4,5,6,1,2
        if (target > nums[mid] || target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid;
        }
      } else {  // eg. 5,6,1,2,3,4
        if (target > nums[mid] && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid;
        }
      }
    }

    if (start == end && target != nums[start]) return -1;
    return start;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.search(new int[] { 1, 3 }, 3));
  }
}
