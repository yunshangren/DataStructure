package solution4;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/7 9:41
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int[] cnt = dp.clone();
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        int res = 0;
        for (int i : dp) {
            if(i == maxLen){
                res++;
            }
        }
        return res;
    }
}
