package solution8;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/29 15:51
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        int res = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                res++;
            }
            end = points[i][0] <= end ? Math.min(end, points[i][1]) : points[i][1];
        }
        return res;
    }

    @Test
    public void test() {
        int[][] arr = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };
        System.out.println(findMinArrowShots(arr));
    }
}
