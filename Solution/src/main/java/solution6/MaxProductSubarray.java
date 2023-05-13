package solution6;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/20 15:42
 */
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n + 1];
        int[] minDp = new int[n + 1];
        maxDp[1] = nums[0];
        minDp[1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            maxDp[i + 1] = Math.max(nums[i], Math.max(nums[i] * maxDp[i], nums[i] * minDp[i]));
            max = Math.max(max, maxDp[i + 1]);
            minDp[i + 1] = Math.min(nums[i], Math.min(nums[i] * maxDp[i], nums[i] * minDp[i]));
        }
        return max;
    }

    @Test
    public void test() {
        int[] arr = {2, 3, -2, 4, -1};
        System.out.println(maxProduct(arr));
    }
}
