package solution4;

/**
 * @author Acer
 * @create 2023/3/2 16:48
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            target -= nums[right++];
            while (target <= 0) {
                res = Math.min(res, (right - left));
                target += nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
