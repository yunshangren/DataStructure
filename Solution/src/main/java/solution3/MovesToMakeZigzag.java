package solution3;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/27 19:34
 */
public class MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int res1 = 0;
        int res2 = 0;

        // 偶数索引元素大
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                if (i != n - 1) {
                    int min = Math.min(nums[i - 1], nums[i + 1]);
                    if (nums[i] >= min) {
                        res1 += nums[i] - min + 1;
                    }
                } else if (nums[i] >= nums[i - 1]) {
                    res1 += nums[i] - nums[i - 1] + 1;
                }
            }
        }

        // 奇数索引元素大
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (i == 0) {
                    if (nums[0] >= nums[1]) {
                        res2 += nums[0] - nums[1] + 1;
                    }
                } else if (i == n - 1) {
                    if (nums[i] >= nums[i - 1]) {
                        res2 += nums[i] - nums[i - 1] + 1;
                    }
                } else {
                    int min = Math.min(nums[i - 1], nums[i + 1]);
                    if (nums[i] >= min) {
                        res2 += nums[i] - min + 1;
                    }
                }
            }
        }
        return Math.min(res1, res2);
    }

    @Test
    public void test(){
        int[] arr = {10,4,4,10,10,6,2,3};
        System.out.println(movesToMakeZigzag(arr));
    }
}
