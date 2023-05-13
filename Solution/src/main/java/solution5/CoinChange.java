package solution5;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/9 10:16
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i],dp[i - coin] + 1);
                }else{
                    break;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void test() {
        int[] coins = {1};
        System.out.println(coinChange(coins,1));
    }
}
