package solution6;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/18 12:15
 */
public class RobII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    public int robRange(int[] nums, int left, int right) {
        int first = 0;
        int second = nums[left];
        for (int i = left + 1; i <= right; i++) {
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }

    @Test
    public void test() {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
