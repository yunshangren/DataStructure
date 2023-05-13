package solution5;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/8 20:37
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (maxPosition >= n - 1) {
                return res + 1;
            }
            if (i == end) {
                end = maxPosition;
                res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {2, 3, 1, 1, 4, 5, 6, 1, 1, 2, 5, 8, 1};
        System.out.println(jump(arr));
    }
}
