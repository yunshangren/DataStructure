package solution12;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Acer
 * @create 2023/5/13 19:08
 */
public class FindPairs {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (k == 0) {
                count += map.get(nums[i]) > 1 ? 1 : 0;
            } else {
                int num = nums[i];
                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findPairs2(int[] nums, int k) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        // 只保存k-diff数对中较小的那个数
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }

    @Test
    public void test() {
        int[] arr = {1, 3, 1, 5, 4};
        System.out.println(findPairs2(arr, 2));
    }
}
