package solution6;


import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/17 14:24
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int[] arr = new int[maxValue + 1];

        for (int num : nums) {
            arr[num] += num;
        }
        int first = 0;
        int second = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = second;
            second = Math.max(second, first + arr[i]);
            first = temp;
        }
        return second;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    @Test
    public void test() {
        int[] arr = {2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(arr));
    }

}
