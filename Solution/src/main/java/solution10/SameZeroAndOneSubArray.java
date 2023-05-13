package solution10;

import java.util.HashMap;

/**
 * @author Acer
 * @create 2023/4/12 21:45
 */
public class SameZeroAndOneSubArray {
    public int findMaxLength(int[] nums) {
        //todo
        return 0;
    }

    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if ((num & 1) == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int res = -1;
        int cnt = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > cnt || (map.get(key) == cnt && key < res)) {
                res = key;
                cnt = map.get(key);
            }
        }
        return res;

    }

}
