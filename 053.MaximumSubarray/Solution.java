public class Solution {

  /* can be much cleaner like this
  public int maxSubArray(int[] nums) {
      int max = Integer.MIN_VALUE;
      int sum = 0;
      for(int i = 0; i<nums.length; i++)
      {
          sum += nums[i];
          if(sum>max)
              max = sum;
          if(sum<0)
              sum = 0;
      }
      return max;
  }
  */
  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int maxSum = nums[0];
    int adjacent = nums[0];
    if (nums[0] < 0) {
      adjacent = 0;
    }

    for (int i = 1; i < nums.length; i += 1) {
      if (nums[i] >= 0) {
        if (adjacent < 0) {
          maxSum = Math.max(nums[i], maxSum);
          adjacent = nums[i];
        } else {
          adjacent += nums[i];
          maxSum = Math.max(adjacent, maxSum);
        }
      } else {
        adjacent += nums[i];
        if (adjacent < 0) {
          adjacent = 0;
        }

        maxSum = Math.max(maxSum, nums[i]);
      }
    }

    return maxSum;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
  }
}
