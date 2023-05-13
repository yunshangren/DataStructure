package solution7;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/28 14:29
 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n + 1][n + 2];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][n + 1] = Integer.MAX_VALUE;
            dp[0][i] = Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        for (int i = n; i > 0; i--) {
            for (int j = 1; j < n + 1; j++) {
                if (i == n) {
                    dp[i][j] = matrix[i - 1][j - 1];
                } else {
                    dp[i][j] = matrix[i - 1][j - 1] +
                            Math.min(dp[i + 1][j - 1],
                                    Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                }
                if (i == 1) {
                    res = Math.min(dp[i][j], res);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {2, 1, 3}, {6, 5, 4}, {7, 8, 9}
        };
        System.out.println(minFallingPathSum(matrix));
    }
}
