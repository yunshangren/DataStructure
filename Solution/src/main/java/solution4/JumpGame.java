package solution4;

/**
 * @author Acer
 * @create 2023/3/3 9:37
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxReach) {
                maxReach = Math.max(maxReach, nums[i] + i);
            }
        }
        return maxReach >= nums.length - 1;
    }
}
