package solution6;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/17 11:49
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // 2 <= cost.length <= 1000
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }

    @Test
    public void test(){
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
