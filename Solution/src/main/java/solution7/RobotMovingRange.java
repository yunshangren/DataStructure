package solution7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2023/3/27 14:33
 */
public class RobotMovingRange {

    public int movingCount(int m, int n, int k) {
        int[][] directions = {{1, 0}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int res = 1;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            for (int[] direction : directions) {
                int x = arr[0] + direction[0];
                int y = arr[1] + direction[1];
                int temp = x / 10 + x % 10 + y / 10 + y % 10;
                if (x >= 0 && x < m
                        && y >= 0 && y < n
                        && !visited[x][y] && temp <= k) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                    res++;
                }
            }
        }
        return res;
    }


}
