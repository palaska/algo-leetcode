import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
  public List<String> generateParenthesis(int n) {
    if (n == 0) {
      return Arrays.asList();
    }

    List<String> init = new ArrayList<>();
    backtrack(init, "", 0, 0, n);
    return list;
  }

  private void backtrack(List<String> list, String str, int open, int close, int max) {
    if (str.length() == max * 2) {
      list.add(str);
      return;
    }

    if (open < max) {
      backtrack(list, str + "(", open + 1, close, max);
    }

    if (close < open) {
      backtrack(list, str + ")", open, close + 1, max);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.generateParenthesis(2));
  }
}

/*
VERY GOOD SOLUTION
public List<String> generateParenthesis(int n) {
       List<String> list = new ArrayList<String>();
       backtrack(list, "", 0, 0, n);
       return list;
 }

 public void backtrack(List<String> list, String str, int open, int close, int max){

     if(str.length() == max*2){
         list.add(str);
         return;
     }

     if(open < max)
         backtrack(list, str+"(", open+1, close, max);
     if(close < open)
         backtrack(list, str+")", open, close+1, max);
 }
 */
/*
public class Solution {
  public class Node {
    int val;
    String str;

    public Node(int val, String str) {
      this.val = val;
      this.str = str;
    }
  }

  public List<String> generateParenthesis(int n) {
    if (n == 0) {
      return Arrays.asList("");
    }

    Node[] nodes = new Node[1];
    nodes[0] = new Node(1, "(");
    int size = 1;

    for (int i = 0; i < 2 * n - 1; i += 1) {
      Node[] newNodes = new Node[size * 2];
      int newIndex = 0;
      for (int j = 0; j < size; j += 1) {
        Node nod = nodes[j];
        if (nod.val < 2 * n - nod.str.length()) {
          newNodes[newIndex++] = new Node(nod.val + 1, nod.str + "(");
        }

        if (nod.val > 0) {
          newNodes[newIndex++] = new Node(nod.val - 1, nod.str + ")");
        }
      }

      nodes = newNodes;
      size = newIndex;
    }

    List<String> result = new LinkedList<String>();

    for (int i = 0; i < size; i += 1) {
      result.add(nodes[i].str);
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.generateParenthesis(4));
  }
}
*/
