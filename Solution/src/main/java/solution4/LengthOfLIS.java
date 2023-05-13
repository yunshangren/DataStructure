package solution4;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/7 9:29
 */
public class LengthOfLIS {
    // 最长递增子序列
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int left = 0;
            int right = res;
            while (left < right) {
                int mid = (left + right) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            if (res == right)
                res++;
        }
        return res;

    }

    @Test
    public void test() {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5};
        System.out.println(lengthOfLIS2(arr));
    }
}
