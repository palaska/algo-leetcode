public class Solution {
  // 30 ms solution
  public int countPrimes(int n) {
    if (n < 3) {
      return 0;
    }

    boolean[] nonPrimes = new boolean[n];

    int cnt = 1;
    for (int i = 3; i < n; i += 2) {
      if (!nonPrimes[i]) {
        cnt += 1;
        int j = 2;
        while ((j * i) < n) {
          nonPrimes[j * i] = true;
          j += 1;
        }
      }
    }

    return cnt;
  }
  /*
  leetcode test cases: 552 ms
  public int countPrimes(int n) {
    if (n < 3) {
      return 0;
    }

    int cnt = 1;
    for (int i = 3; i < n; i += 2) {
      if (isPrime(i)) {
        cnt++;
      }
    }

    return cnt;
  }

  public boolean isPrime(int n) {
    if (n == 2 || n == 3) {
      return true;
    }

    if (n % 2 == 0) {
      return false;
    }

    for (int i = 3; i * i < n + 1; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
  */

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.countPrimes(10));
  }
}
