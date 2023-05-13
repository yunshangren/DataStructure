package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/27 16:38
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            max = Math.max(max,preSum[i]);
        }
        return max;

    }

    @Test
    public void test(){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
