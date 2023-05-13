package solution6;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/19 15:28
 */
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int cur1 = 0;
        int cur2 = 0;
        for (int num : nums) {
            sum += num;
            cur1 += num;
            cur2 += num;
            max = Math.max(max, cur1);
            min = Math.min(min, cur2);
            cur1 = Math.max(0, cur1);
            cur2 = Math.min(0, cur2);
        }
        if (min == sum) {
            return max;
        }
        return Math.max(max, sum - min);
    }

    public int maxSubArraysSum(int[] nums, int startIndex) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int n = nums.length;
        while (n-- > 0) {
            cur += nums[startIndex++];
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
            if (startIndex == nums.length) {
                startIndex = 0;
            }
        }
        return max;
    }

    public int minSubArraySum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int cur = 0;
        for (int num : nums) {
            cur += num;
            min = Math.min(cur, min);
            cur = Math.min(cur, 0);
        }
        return min;
    }

    @Test
    public void test() {
        int[] arr = {5, -3, 4};
        System.out.println(maxSubarraySumCircular(arr));
    }
}
