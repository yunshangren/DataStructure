package solution12;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/5/13 19:59
 */
public class MaxSumMinProduct {
    public int maxSumMinProduct(int[] nums) {
        // 思路和84题一致
        int n = nums.length;
        int mod = (int) (1e9 + 7);
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int[] stack = new int[n];
        int size = 0;
        int[] left = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (size > 0 && nums[i] < nums[stack[size - 1]]) {
                left[stack[--size]] = i;
            }
            stack[size++] = i;
        }
        for (int i = 0; i < size; i++) {
            left[stack[i]] = -1;
        }
        Arrays.fill(stack, 0);
        size = 0;
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (size > 0 && nums[i] < nums[stack[size - 1]]) {
                right[stack[--size]] = i;
            }
            stack[size++] = i;
        }
        for (int i = 0; i < size; i++) {
            right[stack[i]] = n;
        }
        long max = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            max = Math.max(max, num * (preSum[right[i]] - preSum[left[i] + 1]));
        }
        return (int) (max % mod);
    }

    @Test
    public void test() {
        int[] arr = {2, 3, 3, 1, 2};
        System.out.println(maxSumMinProduct(arr));
    }
}
