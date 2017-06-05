public class Solution {
  /*
  CLEANER SOLUTION, sum one by one
  public int trap(int[] A){
      int a=0;
      int b=A.length-1;
      int max=0;
      int leftmax=0;
      int rightmax=0;
      while(a<=b){
          leftmax=Math.max(leftmax,A[a]);
          rightmax=Math.max(rightmax,A[b]);
          if(leftmax<rightmax){
              max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
              a++;
          }
          else{
              max+=(rightmax-A[b]);
              b--;
          }
      }
      return max;
  }
  */
  public int trap(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int maxWaterHeight = 0;
    int countedHeight = 0;
    int reserve = 0;

    while (i < j) {
      if (countedHeight >= height[i]) {
        i++;
        continue;
      }

      if (countedHeight >= height[j]) {
        j--;
        continue;
      }

      maxWaterHeight = Math.min(height[i], height[j]);

      for (int k = i + 1; k < j; k += 1) {
        int effectiveHeight = Math.max(height[k], countedHeight);
        int h = maxWaterHeight - effectiveHeight;

        if (h > 0) {
          reserve += h;
        }
      }

      if (height[i] < height[j]) {
        i++;
      } else if (height[i] > height[j]) {
        j--;
      } else {
        i++;
        j--;
      }

      countedHeight = Math.max(countedHeight, maxWaterHeight);
    }

    return reserve;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.trap(new int[] {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));

    //                                            #
    /*                        #                   #
    #                         #                 # #
    #                   #     # #               # #
    # #               # #     # #             # # #
    # #     #     #   # # #   # # #         # # # #   #
    # # #   # #   #   # # # # # # #     #   # # # #   #
    # # #   # #   # # # # # # # # #   # # # # # # # # #

    */
  }
}
