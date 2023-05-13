package solution11;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/5/3 13:31
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        int[] stack = new int[n << 1];
        int size = 0;
        for (int i = 0; i < (n << 1); i++) {
            while (size > 0 && nums[i % n] > nums[stack[size - 1]]) {
                res[stack[size - 1]] = nums[i % n];
                size--;
            }
            stack[size++] = i % n;
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }
}
