package solution10;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/13 21:34
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        int min = 1;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            if (useTime(piles, mid) > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public int useTime(int[] piles, int speed) {
        int res = 0;
        for (int pile : piles) {
            res += (pile + speed - 1) / speed;
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(arr, 8));
    }
}
