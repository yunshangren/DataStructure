package solution3;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/24 9:41
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 1 <= nums[i] <= 1000
        if (k < 2) {
            return 0;
        }

        int res = 0;
        int left = 0;
        int right = 0;
        int product = 1;
        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            res += right - left + 1;
            right++;
        }
        return res;

    }

    @Test
    public void test() {
        int[] nums = {10, 5, 2, 6};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }
}
