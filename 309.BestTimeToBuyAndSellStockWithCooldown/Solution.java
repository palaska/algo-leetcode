public class Solution {
  /*
  better O(n) solution
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
        return 0;
    }
    int len = prices.length;
    int[][] dp = new int[len][3];
    dp[0][0] = -prices[0]; dp[0][1] = 0; dp[0][2] = 0;
    int localMax = dp[0][0];
    for (int i = 1; i < len; i++) {
        dp[i][1] = localMax + prices[i]; //sell
        dp[i][0] = dp[i - 1][2] - prices[i]; // buy
        localMax = Math.max(localMax, dp[i][0]);
        dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]); //cooldown
    }
    int ans = Math.max(dp[len - 1][1], dp[len - 1][2]);
    ans = Math.max(ans, 0);
    return ans;
  }
  */
  /*
    on day i,
    SELL -> bought on i - 1 / did nothing on i - 1
    profit(i) = profit[i - 1] + prices[i]

    BUY -> did nothing on i - 1
    profit(i) = profit[i - 1] - prices[i]

    REST -> bought on i - 1 / did nothing on i - 1 / sold on i - 1
    profit(i) = profit[i - 1]
  */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int firstDayBuy = getActionResult('b', prices, 1, 0, false);
    int firstDayRest = getActionResult('r', prices, 1, 0, false);

    return Math.max(firstDayBuy, firstDayRest);
  }

  public int getActionResult(char action, int[] prices, int day, int currentMoney, boolean boughtBefore) {
    // action: 'b', 's', 'r'
    if (day == prices.length) {
      if (action == 'b') {
        return currentMoney - prices[day - 1];
      }

      if (action == 's') {
        return currentMoney + prices[day - 1];
      }

      if (action == 'r') {
        return currentMoney;
      }

      return 0;
    }

    if (action == 'b') {
      return Math.max(
        getActionResult('s', prices, day + 1, currentMoney - prices[day - 1], true),
        getActionResult('r', prices, day + 1, currentMoney - prices[day - 1], true)
      );
    }

    if (action == 's') {
      return getActionResult('r', prices, day + 1, currentMoney + prices[day - 1], false);
    }

    if (action == 'r') {
      if (boughtBefore) {
        return Math.max(
          getActionResult('r', prices, day + 1, currentMoney, boughtBefore),
          getActionResult('s', prices, day + 1, currentMoney, boughtBefore)
        );
      }

      return Math.max(
        getActionResult('r', prices, day + 1, currentMoney, boughtBefore),
        getActionResult('b', prices, day + 1, currentMoney, boughtBefore)
      );
    }

    return 0;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.maxProfit(new int[] {2,1,4}));
    // s.maxProfit(new int[] {1,2});
    // System.out.println(s.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    // System.out.println(s.maxProfit(new int[] {7, 6, 4, 3, 1}));
  }
}
