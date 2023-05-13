package solution4;

/**
 * @author Acer
 * @create 2023/3/3 9:51
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
        }

    }

    public int robRange(int[] nums, int left, int right) {
        int first = nums[left];
        int second = Math.max(nums[left],nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }
}
