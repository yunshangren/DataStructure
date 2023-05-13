package solution.slidingWindow;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Acer
 * @create 2022/11/8 10:02
 */
public class MaximumSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        long maxSum = 0;
        long sum = 0;
        while (right < nums.length) {
            int num = nums[right++];
            window.put(num, window.getOrDefault(num, 0) + 1);
            sum += num;
            while (right - left == k) {
                if (window.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }
                int n = nums[left++];
                sum -= n;
                window.put(n, window.get(n) - 1);
                if (window.get(n) == 0) {
                    window.remove(n);
                }
            }
        }
        return maxSum;

    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(maximumSubarraySum(arr, 6));
    }
}
