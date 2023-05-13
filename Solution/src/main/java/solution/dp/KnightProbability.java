package solution.dp;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/4 15:32
 */
public class KnightProbability {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        int[][] dirs = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
        for (int i = 0; i <= k; i++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (i == 0) {
                        dp[0][r][c] = 1;
                    } else {
                        for (int[] dir : dirs) {
                            int rd = r + dir[0];
                            int cd = c + dir[1];
                            if (rd >= 0 && rd < n && cd >= 0 && cd < n) {
                                dp[i][r][c] += dp[i - 1][rd][cd] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }

    public int process(int n, int k, int row, int col, int[][][] dp) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            dp[k][row][col] = 0;
            return 0;
        } else if (k == 0) {
            dp[k][row][col] = 1;
            return 1;
        }
        dp[k][row][col] = dp[k - 1][row - 1][col - 2]
                + dp[k - 1][row - 2][col - 1]
                + dp[k - 1][row - 2][col + 1]
                + dp[k - 1][row - 1][col + 2]
                + dp[k - 1][row + 1][col + 2]
                + dp[k - 1][row + 2][col + 1]
                + dp[k - 1][row + 2][col - 1]
                + dp[k - 1][row + 1][col - 2];
        return dp[k][row][col];

    }

    @Test
    public void test() {
        System.out.println(knightProbability(8, 30, 6, 4));
    }
}
