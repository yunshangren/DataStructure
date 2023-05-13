package solution7;

import java.util.HashMap;

/**
 * @author Acer
 * @create 2023/3/23 19:54
 */
public class CountBadPairs {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long res = (long) n * (n - 1) >> 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, -1) + 1);
            res -= map.get(nums[i] - i);
        }
        return res;
    }
}
