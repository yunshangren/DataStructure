package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2022/11/2 8:59
 */
public class BestCoordinate {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] res = new int[2];
        int max = 0;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int[] tower : towers) {
            maxX = Math.max(maxX, tower[0]);
            maxY = Math.max(maxY, tower[1]);
        }
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                int temp = 0;
                for (int[] tower : towers) {
                    double distance = distance(i, j, tower[0], tower[1]);
                    if (distance <= radius * radius) {
                        temp += tower[2] / (1 + Math.sqrt(distance));
                    }
                }
                if (temp > max) {
                    max = temp;
                    res[0] = i;
                    res[1] = j;
                }
            }

        }
        return res;

    }

    public double distance(int x1, int y1, int x2, int y2) {
        return Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
    }

    @Test
    public void test() {
        int[][] towers = {
                {0, 1, 2},
                {2, 1, 2},
                {1, 0, 2},
                {1, 2, 2},

        };
        System.out.println(Arrays.toString(bestCoordinate(towers, 2)));
    }
}
