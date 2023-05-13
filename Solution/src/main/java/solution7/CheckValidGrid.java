package solution7;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/22 15:53
 */
public class CheckValidGrid {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int[][] directions = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
        int target = 1;
        int row = 0;
        int col = 0;
        int n = grid.length;
        int total = n * n;
        while (target < total) {
            boolean success = false;
            for (int[] direction : directions) {
                int x = direction[0] + row;
                int y = direction[1] + col;
                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == target) {
                    target++;
                    success = true;
                    row = x;
                    col = y;
                    break;
                }
            }
            if (!success) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[][] grid = {
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}
        };
        System.out.println(checkValidGrid(grid));
    }
}
