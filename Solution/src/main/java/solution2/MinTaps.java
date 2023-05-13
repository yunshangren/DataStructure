package solution2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Acer
 * @create 2023/2/21 16:29
 */
public class MinTaps {
    public int minTaps(int n, int[] ranges) {
        //ranges.length == n + 1
        int[][] intervals = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            intervals[i][0] = Math.max(0, i - ranges[i]);
            intervals[i][1] = Math.min(n, i + ranges[i]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int res = 0; // 最小水龙头个数
        int cur = 0; // 当前最大覆盖位置
        int p = 0; // 上一次拼接的终点
        while (cur < n) {
            for (int i = 0; i < n + 1 && intervals[i][0] <= p; i++) {
                cur = Math.max(cur, intervals[i][1]);
            }
            if(cur == p){
                return -1;
            }
            p = cur;
            res++;
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {3, 4, 1, 1, 0, 0};
        System.out.println(minTaps(5, arr));
    }
}
