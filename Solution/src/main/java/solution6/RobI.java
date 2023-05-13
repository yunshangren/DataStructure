package solution6;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/17 16:29
 */
public class RobI {


    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    @Test
    public void test(){
        int[] arr = {2,2,3,3,3,4};

    }
}
