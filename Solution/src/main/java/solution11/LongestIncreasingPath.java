package solution11;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/18 10:18
 */
public class LongestIncreasingPath {
    int[][] memo;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;


        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int res = 1;
        int temp = 0;
        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[row][col]) {
                temp = Math.max(temp, dfs(matrix, x, y));
            }
        }
        res += temp;
        memo[row][col] = res;
        return res;
    }

    @Test
    public void test() {
        int[][] mat = {
                {5, 4, 3},
                {6, 2, 2},
                {7, 8, 6}
        };
        System.out.println(longestIncreasingPath(mat));
    }
}
