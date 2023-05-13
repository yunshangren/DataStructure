package solution6;

/**
 * @author Acer
 * @create 2023/3/21 9:31
 */
public class MaxProfit {
    public int maxProfit1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }


    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }

    // 最佳买卖股票时机含冷冻期
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[i][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
                dp[i][1] = Math.max(dp[0][1], -prices[1]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    // 含手续费
    public int maxProfit4_1(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // dp[i][0] 非持有该股票最大利润
        // dp[i][1] 持有该股票最大利润
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }

    public int maxProfit4_2(int[] prices, int fee) {
        int n = prices.length;
        int preNo = 0;
        int preYes = -prices[0] - fee;
        int curNo = 0;
        int curYes;
        for (int i = 1; i < n; i++) {
            curNo = Math.max(preNo, preYes + prices[i]);
            curYes = Math.max(preYes, preNo - prices[i] - fee);
            preNo = curNo;
            preYes = curYes;
        }
        return curNo;
    }

    //  最大交易次数为2
    public int maxProfit5(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        int cnt = 2;
        for (int i = 0; i < n; i++) {
            for (int j = cnt; j > 0; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][cnt][0];
    }

    // 最大交易次数为k
    public int maxProfit6(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            return maxProfit2(prices);
        }
        int[][][] dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = k; j > 0; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }


}
