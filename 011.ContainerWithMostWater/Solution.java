public class Solution {
  // https://leetcode.com/articles/container-most-water/
    /*
    // O(n^2) solution
    public static int maxArea(int[] height) {
      // container height * bottom length
      int max = 0;
      for (int i = 1; i <= height.length; i += 1) {
        for (int j = i + 1; j <= height.length; j += 1) {
          int bottomLength = Math.abs(i - j);
          int realHeight = Math.min(height[i - 1], height[j - 1]);
          int area = bottomLength * realHeight;
          if (area > max) {
            max = area;
          }
        }
      }

      return max;
    }
    */

    public static int maxArea(int[] height) {
      // container height * bottom length
      int maxArea = 0;
      int i = 0;
      int j = height.length - 1;

      while (i < j) {
        int containerHeight = Math.min(height[i], height[j]);
        int containerWidth = j - i;
        int area = containerHeight * containerWidth;

        if (area > maxArea) {
          maxArea = area;
        }

        if (height[i] > height[j]) {
          j--;
        } else {
          i++;
        }
      }

      return maxArea;
    }

    public static void main(String[] args) {
      // TODO
      System.out.println(maxArea(new int[] {2, 1, 3}));
    }
}
