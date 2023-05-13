package solution9;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/4/7 9:43
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int leftRow = 0;
        int leftCol = 0;
        int rightRow = matrix.length - 1;
        int rightCol = matrix[0].length - 1;
        int[] res = new int[(rightRow + 1) * (rightCol + 1)];
        int index = 0;
        while (leftRow <= rightRow && leftCol <= rightCol) {
            if (leftRow == rightRow && leftCol == rightCol) {
                res[index] = matrix[leftRow][leftCol];
                return res;
            } else if (leftRow == rightRow) {
                for (int i = leftCol; i <= rightCol; i++) {
                    res[index++] = matrix[leftRow][i];
                }
                return res;
            } else if (leftCol == rightCol) {
                for (int i = leftRow; i <= rightRow; i++) {
                    res[index++] = matrix[i][leftCol];
                }
                return res;
            }
            for (int i = leftCol; i < rightCol; i++) {
                res[index++] = matrix[leftRow][i];
            }
            for (int i = leftRow; i < rightRow; i++) {
                res[index++] = matrix[i][rightCol];
            }
            for (int i = rightCol; i > leftCol; i--) {
                res[index++] = matrix[rightRow][i];
            }
            for (int i = rightRow; i > leftRow; i--) {
                res[index++] = matrix[i][leftCol];
            }
            leftRow++;
            leftCol++;
            rightRow--;
            rightCol--;
        }
        return res;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }
}
