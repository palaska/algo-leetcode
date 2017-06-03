public class Solution {
  public int countSegments(String s) {
    s = s.trim(); // we get rid of spaces in the sides

    if (s.length() == 0) {
      return 0;
    }

    char[] charArr = s.toCharArray();

    boolean previousIsSpace = false;
    int innerSpaceCnt = 0;
    for (int i = 0; i < charArr.length; i += 1) {
      if (charArr[i] == ' ') {
        if (!previousIsSpace) {
          innerSpaceCnt += 1;
          previousIsSpace = true;
        }
      } else {
        previousIsSpace = false;
      }
    }

    return innerSpaceCnt + 1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.countSegments("sdaf sdafasd fasfdsa    dfadsf  sdaf     sdf"));
  }
}
