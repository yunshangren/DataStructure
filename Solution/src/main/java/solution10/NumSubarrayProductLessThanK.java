package solution10;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/12 21:06
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                res++;
            }
            int pro = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                pro *= nums[j];
                if (pro < k) {
                    res++;
                } else {
                    break;
                }

            }
        }
        return res;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int res = 0;
        int pro = 1;
        while (right < nums.length) {
            pro *= nums[right++];
            while (left <= right && pro >= k) {
                pro /= nums[left++];
            }
            res += right - left;
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4};
        System.out.println(numSubarrayProductLessThanK1(arr, 25));
        System.out.println(numSubarrayProductLessThanK2(arr, 25));
    }
}
