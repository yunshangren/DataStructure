package solution.slidingWindow;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/26 18:32
 */
public class ShortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int left = 0;
        int right = 0;
        int res = -1;
        int sum = 0;
        while (right < nums.length) {
            int i1 = nums[right];
            right++;
            sum += i1;

            while (sum >= k) {
                int i2 = nums[left];
                if (res == -1 || res > right - left) {
                    res = right - left;
                }
                sum -= i2;
                left++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {80, 4, -37, 32, 40, 95};
        System.out.println(shortestSubarray(arr, 167));
    }
}
