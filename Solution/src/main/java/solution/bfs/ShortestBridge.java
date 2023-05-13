package solution.bfs;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/25 9:55
 */
public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        boolean find = false;
        for (int i = 0; i < grid.length; i++) {
            if (find) {
                break;
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    infect(grid, i, j);
                    find = true;
                    break;
                }
            }
        }
        int res = Integer.MAX_VALUE;

        return res;

    }

    public void infect(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1) {
            return;
        }
        if (grid[row][col] == 1) {
            grid[row][col] = -1;
            infect(grid, row - 1, col);
            infect(grid, row + 1, col);
            infect(grid, row, col - 1);
            infect(grid, row, col + 1);
        }
    }
    public void dfs(int[][] grid, boolean[][] visited, int row, int col){

    }

    @Test
    public void test() {
        int[][] arr = {
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };
        System.out.println(shortestBridge(arr));
    }
}
