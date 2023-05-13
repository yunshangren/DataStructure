package solution10;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Acer
 * @create 2023/4/16 14:56
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        int max = -0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int pre = map.get(counter);
                max = Math.max(max, i - pre);
            } else {
                map.put(counter, i);
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] arr = {0, 1};
        System.out.println(findMaxLength(arr));
    }
}
