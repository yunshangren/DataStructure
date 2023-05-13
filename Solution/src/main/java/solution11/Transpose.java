package solution11;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/5/3 14:12
 */
public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(1 << 10);
    }
}
