package solution7;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/24 15:56
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        // 1 <= n <= 20
        int n = matrix.length;
        int leftRow = 0;
        int leftCol = 0;
        int rightRow = n - 1;
        int rightCol = n - 1;
        while (leftRow < rightRow && leftCol < rightCol) {
            for (int i = leftCol; i < rightCol; i++) {
                int temp = matrix[leftRow][i];
                matrix[leftRow][i] = matrix[n - 1 - i][leftCol];
                matrix[n - 1 - i][leftCol] = matrix[rightRow][n - 1 - i];
                matrix[rightRow][n - 1 - i] = matrix[i][rightCol];
                matrix[i][rightCol] = temp;
            }
            leftRow++;
            leftCol++;
            rightRow--;
            rightCol--;
        }
    }

    @Test
    public void test() {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
