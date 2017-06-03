public class Solution {
  public String countThis(String n) {
    char[] charArr = n.toCharArray();

    StringBuilder str = new StringBuilder();
    int cnt = 1;
    char last = charArr[0];

    for (int i = 1; i < charArr.length; i += 1) {
      if (charArr[i] == last) {
        cnt++;
      } else {
        str.append(cnt);
        str.append(last);
        cnt = 1;
        last = charArr[i];
      }
    }

    str.append(cnt);
    str.append(last);

    return str.toString();
  }

  public String countAndSay(int n) {
    String current = "1";
    for (int i = 1; i < n; i += 1) {
      current = countThis(current);
    }

    return current;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.countAndSay(8));
  }
}
