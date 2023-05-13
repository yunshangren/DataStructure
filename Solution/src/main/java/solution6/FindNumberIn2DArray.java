package solution6;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/18 9:27
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        // 从右上角的位置出发
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;

    }

    @Test
    public void test() {
        int[][] matrix = {{}};
        System.out.println(findNumberIn2DArray(matrix, 1));
    }
}
