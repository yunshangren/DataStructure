package solution3;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Acer
 * @create 2023/2/24 10:05
 */
public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }

    public int minimumOperations1(int[] nums) {
        int res = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int temp = nums[i];
                for (int j = i; j < nums.length; j++) {
                    nums[j] -= temp;
                }
                res++;
            }
        }
        return res;
    }

    public int minimumOperations2(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                subtract(nums, nums[i], i);
                ans++;
            }
        }
        return ans;
    }

    public void subtract(int[] nums, int x, int startIndex) {
        int length = nums.length;
        for (int i = startIndex; i < length; i++) {
            nums[i] -= x;
        }
    }


    @Test
    public void test() {
        int[] arr = {1, 5, 0, 3, 5};
        //System.out.println(minimumOperations(arr));
        System.out.println(minimumOperations1(arr));
        //System.out.println(minimumOperations2(arr));

    }
}
