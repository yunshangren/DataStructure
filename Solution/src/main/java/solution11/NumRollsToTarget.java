package solution11;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/27 14:25
 */
public class NumRollsToTarget {
    int res = 0;

    public int numRollsToTarget(int n, int k, int target) {
        int mod = (int) (1e9 + 7);
        // n 个骰子，[1,k]
        if (target < n || target / n > k) {
            return 0;
        }
        int m = Math.max(target, k);
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < k + 1; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = i; j <= Math.min(i * k, m); j++) {
                for (int l = Math.max(1, j - k); l <= j - 1; l++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][l]) % mod;
                }
                dp[i][j] %= mod;
            }
        }
        return dp[n][target];
    }

    @Test
    public void test() {
        System.out.println(numRollsToTarget(30, 30, 500));
    }

}


