package solution.dfs;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/9 9:51
 */
public class OrderOfLargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (mines.length == 0) {
            return (n + 1) >> 1;
        }
        int[][] grid = new int[n][n];

        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                // 上
                int up = 0;
                for (int k = i - 1; k >= 0; k--) {
                    if (grid[k][j] == 1) {
                        break;
                    }
                    up++;
                }
                // 下
                int down = 0;
                for (int k = i + 1; k < n; k++) {
                    if (grid[k][j] == 1) {
                        break;
                    }
                    down++;
                }
                // 左
                int left = 0;
                for (int k = j - 1; k >= 0; k--) {
                    if (grid[i][k] == 1) {
                        break;
                    }
                    left++;
                }
                // 右
                int right = 0;
                for (int k = j + 1; k < n; k++) {
                    if (grid[i][k] == 1) {
                        break;
                    }
                    right++;
                }
                res = Math.max(res, Math.min(Math.min(up, down), Math.min(left, right)) + 1);
            }
        }
        return res;
    }


    @Test
    public void test() {
        int[][] mines = {{4, 2}};
        System.out.println(orderOfLargestPlusSign(9, mines));
    }
}
