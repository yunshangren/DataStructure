package solution6;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Acer
 * @create 2023/3/16 14:07
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // key ---> 数组的前缀和
        // value ---> 对应前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                res += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {1};
        System.out.println(subarraySum(arr, 0));
    }
}
