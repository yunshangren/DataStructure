package solution3;

/**
 * @author Acer
 * @create 2023/2/24 9:53
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int curSum = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < nums.length){
            curSum += nums[right++];
            while (curSum >= target){
                minLen = Math.min(minLen,(right - left));
                curSum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
