package solution3;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2023/2/27 13:15
 */
public class ShortestPathBinaryMatrix {
    // 路径途经的所有单元格都的值都是 0 。
    // 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[n][n];
        int[][] matrix = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int res = 1;
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                if (arr[0] == n - 1 && arr[1] == n - 1) {
                    return res;
                }

                for (int[] num : matrix) {
                    int row = arr[0] + num[0];
                    int col = arr[1] + num[1];
                    if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || grid[row][col] == 1) {
                        continue;
                    }

                    queue.add(new int[]{row, col});
                    visited[row][col] = true;
                }

            }
            res++;
        }
        return -1;
    }

    @Test
    public void test() {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

}
