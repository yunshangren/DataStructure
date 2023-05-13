package solution8;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/29 14:06
 */
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lr = Math.max(0, i - k);
                int lc = Math.max(0, j - k);
                int rr = Math.min(m - 1, i + k);
                int rc = Math.min(n - 1, j + k);
                if (lr == 0 && lc == 0) {
                    res[i][j] = preSum[rr + 1][rc + 1];
                } else {
                    res[i][j] = preSum[rr + 1][rc + 1] - preSum[lr][rc + 1] - preSum[rr + 1][lc] + preSum[lr][lc];
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int[][] ints = matrixBlockSum(matrix, 2);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
