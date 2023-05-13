package solution3;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/2/28 10:30
 */
public class LeftRightDifference {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            left[i] += nums[i - 1] + left[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i + 1] + right[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.abs(left[i] - right[i]);
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {10, 4, 8, 3};
        System.out.println(Arrays.toString(leftRightDifference(arr)));
    }
}
