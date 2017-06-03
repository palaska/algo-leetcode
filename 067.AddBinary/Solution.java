public class Solution {
  public String addBinary(String a, String b) {
    boolean hasRemainder = false;
    char[] charA = a.toCharArray();
    char[] charB = b.toCharArray();
    int lastA = charA.length - 1;
    int lastB = charB.length - 1;
    StringBuilder str = new StringBuilder();

    while (lastA >= 0 || lastB >= 0) {
      if (lastA < 0) {
        if (charB[lastB] == '1') {
          if (hasRemainder) {
            str.append("0");
          } else {
            str.append("1");
          }
        } else {
          if (hasRemainder) {
            str.append("1");
            hasRemainder = false;
          } else {
            str.append("0");
          }
        }
      } else if (lastB < 0) {
        if (charA[lastA] == '1') {
          if (hasRemainder) {
            str.append("0");
          } else {
            str.append("1");
          }
        } else {
          if (hasRemainder) {
            str.append("1");
            hasRemainder = false;
          } else {
            str.append("0");
          }
        }
      } else {
        if (charA[lastA] == '1') {
          if (charB[lastB] == '1') {
            if (hasRemainder) {
              str.append("1");
            } else {
              str.append("0");
              hasRemainder = true;
            }
          } else {
            if (hasRemainder) {
              str.append("0");
            } else {
              str.append("1");
            }
          }
        } else {
          if (charB[lastB] == '1') {
            if (hasRemainder) {
              str.append("0");
            } else {
              str.append("1");
            }
          } else {
            if (hasRemainder) {
              str.append("1");
              hasRemainder = false;
            } else {
              str.append("0");
            }
          }
        }
      }

      lastA--;
      lastB--;
    }

    if (hasRemainder) {
      str.append("1");
    }

    return str.reverse().toString();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.addBinary("11", "1"));
  }
}
