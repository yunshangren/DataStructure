package solution6;

/**
 * @author Acer
 * @create 2023/3/21 10:42
 */
public class GetMaxLen {
    // 请你求出乘积为正数的最长子数组的长度。
    // 1 <= nums.length <= 10^5
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];
        pos[0] = nums[0] > 0 ? 1 : 0;
        neg[0] = nums[0] < 0 ? 1 : 0;
        int maxLen = pos[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                pos[i] = pos[i - 1] + 1;
                neg[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                pos[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
                neg[i] = pos[i - 1] + 1;
            } else {
                pos[i] = 0;
                neg[i] = 0;
            }
            maxLen = Math.max(maxLen, pos[i]);
        }
        return maxLen;
    }
}
