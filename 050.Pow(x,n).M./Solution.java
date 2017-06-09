import java.util.HashMap;

public class Solution {
  /*
  public double myPow(double x, int n) {
      if(n == 0) return 1;
      if(n == Integer.MIN_VALUE){
          x = x * x;
          n = n/2;
      }
      if(n < 0) {
          n = -n;
          x = 1/x;
      }

      return (n%2 == 0) ? myPow(x * x, n/2) : x *  myPow(x * x, n/2);
  }
  */

  HashMap<String, Double> map = new HashMap<>();

  public double myPow(double x, int n) {
    if (n == 0) {
      return (double) 1;
    }

    if (n == 1) {
      return x;
    }

    StringBuilder str = new StringBuilder();
    str.append(Double.toString(x));
    str.append(Integer.toString(n));

    if (map.containsKey(str.toString())) {
      return map.get(str.toString());
    }

    boolean isNegative = false;
    boolean isMinInt = false;

    if (n < 0) {
      isNegative = true;
      if (n == Integer.MIN_VALUE) {
        isMinInt = true;
        n += 1;
      }

      n *= -1;
    }

    double result;

    if (n % 2 == 1) {
      if (isNegative) {
        result = (double) 1 / (myPow(x, (n - 1) / 2) * myPow(x, (n - 1) / 2) * x);
        if (isMinInt) {
          result *= 1 / x;
        }
      } else {
        result = (double) myPow(x, (n - 1) / 2) * myPow(x, (n - 1) / 2) * x;
      }
    } else {
      if (isNegative) {
        result = (double) 1 / (myPow(x, n/2) * myPow(x, n/2));
      } else {
        result = (double) myPow(x, n/2) * myPow(x, n/2);
      }
    }

    map.put(str.toString(), result);
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.myPow(2.00000, -2147483648));
  }
}
