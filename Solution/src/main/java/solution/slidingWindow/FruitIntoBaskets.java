package solution.slidingWindow;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Acer
 * @create 2022/10/18 9:04
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;

        int res = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            right++;
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 2, 2};
        System.out.println(totalFruit(arr));
    }
}
