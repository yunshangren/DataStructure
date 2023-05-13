package solution.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2022/11/9 11:05
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int maxLen = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    public int binarySearch(int[] arr, int target, int left, int right){
        while (left <= right){
            int mid = ((right - left) >> 1) + left;
            if(arr[mid] < target){
                left = mid + 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] arr = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(arr));
    }
}
