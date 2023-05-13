package solution10;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/16 20:43
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum || target < -sum) {
            return 0;
        }
        int n = (sum << 1) + 1;
        int mid = n >> 1;
        int[] dp = new int[n];
        dp[mid] = 1;
        for (int num : nums) {
            int[] temp = new int[n];
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] > 0) {
                    int count = dp[i];
                    temp[i - num] += count;
                    temp[i + num] += count;
                }
            }
            dp = temp;
        }
        return dp[mid + target];
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(arr, 3));

    }

}
