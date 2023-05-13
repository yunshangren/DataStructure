package solution8;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/4/4 9:34
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChangeII(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];

    }

    public int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 1;
        }
        int res = 0;
        for (int coin : coins) {
            if (amount >= coin) {
                int temp = dfs(coins, amount - coin);
                if (temp != -1) {
                    res += temp;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {186, 419, 83, 408};
        System.out.println(coinChange(arr, 6249));
    }
}
