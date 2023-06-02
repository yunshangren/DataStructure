package solution12;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/6/1 13:04
 */
public class MaximumTastiness {
    // 礼盒的最大甜蜜度
    // 礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int min = 0;
        int max = price[n - 1] - price[0];
        int res = 0;
        while (min <= max) {
            int mid = ((max - min) >> 1) + min;
            if (f(price, k, mid)) {
                res = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return res;

    }

    public boolean f(int[] price, int k, int tastiness) {

        int cnt = 0;
        int pre = 0;
        for (int i : price) {
            // 当前这个price - 上次选的price >= 给定的甜蜜度
            if (cnt == 0 || i - pre >= tastiness) {
                pre = i;
                cnt++;
            }
        }
        return cnt >= k;
    }


}
