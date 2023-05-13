package solution8;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/4 15:13
 */
public class MaximumHourglassSum {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + grid[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 3; i < m + 1; i++) {
            for (int j = 3; j < n + 1; j++) {
                res = Math.max(res, preSum[i][j] - preSum[i - 3][j] - preSum[i][j - 3] + preSum[i - 3][j - 3]
                        - grid[i - 2][j - 3] - grid[i - 2][j - 1]);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {6, 2, 1, 3},
                {4, 2, 1, 5},
                {9, 2, 8, 7},
                {4, 1, 2, 9},
        };
        System.out.println(maxSum(matrix));
    }
}
