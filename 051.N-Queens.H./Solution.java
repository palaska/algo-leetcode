import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> solutions = new ArrayList<List<String>>();
    backtrack(solutions, Arrays.asList(), 0, n, Arrays.asList(), Arrays.asList(), Arrays.asList());
    return solutions;
  }

  public void backtrack(List<List<String>> solutions, List<String> currentBoard, int qCnt, int max, List<Integer> seenIndices, List<Integer> slopeMinusOneLine, List<Integer> slopePlusOneLine) {
    if (qCnt == max) {
      solutions.add(currentBoard);
      return;
    }

    int yIndex = qCnt + 1;

    for (int i = 0; i < max; i += 1) {
      int nix = i + yIndex;
      int pix = i - yIndex;

      if (!seenIndices.contains(i) && !slopeMinusOneLine.contains(nix) && !slopePlusOneLine.contains(pix)) {
        StringBuilder str = new StringBuilder();

        for (int j = 0; j < max; j += 1) {
          if (i == j) {
            str.append("Q");
          } else {
            str.append(".");
          }
        }

        List<String> newCurrentBoard = new ArrayList<>(currentBoard);
        newCurrentBoard.add(str.toString());

        List<Integer> newSeenIndices = new ArrayList<>(seenIndices);
        newSeenIndices.add(i);

        List<Integer> newSlopeMinusOneLine = new ArrayList<>(slopeMinusOneLine);
        newSlopeMinusOneLine.add(nix);

        List<Integer> newSlopePlusOneLine = new ArrayList<>(slopePlusOneLine);
        newSlopePlusOneLine.add(pix);

        backtrack(solutions, newCurrentBoard, yIndex, max, newSeenIndices, newSlopeMinusOneLine, newSlopePlusOneLine);
      }
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solveNQueens(5));
  }
}
