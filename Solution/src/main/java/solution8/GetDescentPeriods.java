package solution8;

/**
 * @author Acer
 * @create 2023/3/31 16:01
 */
public class GetDescentPeriods {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 1;
        long res = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = prices[i] == prices[i - 1] - 1 ? dp[i - 1] + 1 : 1;
            res += dp[i];
        }
        return res;
    }
}
