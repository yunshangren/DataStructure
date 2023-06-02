package solution12;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/5/15 12:58
 */
public class FindRadius {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int m = houses.length;
        int n = heaters.length;
        if (houses[m - 1] <= heaters[0]) {
            return heaters[0] - houses[0];
        }
        if (houses[0] >= heaters[n - 1]) {
            return houses[m - 1] - heaters[n - 1];
        }

        int left = 0;
        int right = houses[m - 1] - houses[0];
        int res = 0;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (f(houses, heaters, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;

    }

    public boolean f(int[] houses, int[] heater, int radius) {
        int m = houses.length;
        boolean[] arr = new boolean[houses[m - 1] + 1];
        for (int i : heater) {
            for (int j = i - radius; j <= i + radius; j++) {
                arr[i] = true;
            }
        }
        for (int house : houses) {
            if (!arr[house]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] houses = {1, 2, 3};
        int[] heaters = {1, 2, 3};
        System.out.println(findRadius(houses, heaters));
    }
}
