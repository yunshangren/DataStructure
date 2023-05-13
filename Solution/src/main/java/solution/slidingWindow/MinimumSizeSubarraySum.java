package solution.slidingWindow;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/17 17:07
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;

        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length){
            sum += nums[right];
            right++;

            while (sum >= target){
                sum -= nums[left];
                len = Math.min(len,(right - left));
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;

    }

    @Test
    public void test(){
        int[] arr = {1,4,4,5,8};
        System.out.println(minSubArrayLen(13,arr));
    }
}
