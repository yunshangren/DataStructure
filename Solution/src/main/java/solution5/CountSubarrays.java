package solution5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Acer
 * @create 2023/3/16 10:32
 */
public class CountSubarrays {
    public int countSubarrays(int[] nums, int k) {
        int preSum = 0;
        int res = 0;
        int kValue = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            if (num < k) {
                --preSum;
            } else if (num > k) {
                ++preSum;
            } else {
                preSum += kValue;
            }

            if (map.containsKey(preSum - kValue)) {
                res += map.get(preSum - kValue);
            }
            if (map.containsKey(preSum - kValue - 1)) {
                res += map.get(preSum - kValue - 1);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }


    @Test
    public void test() {
        int[] nums = {2, 5, 1, 4, 3, 6};
        System.out.println(countSubarrays(nums, 1));
    }
}
