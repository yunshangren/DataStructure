package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        rotateEdge(matrix, 0, 0, m - 1, n - 1);
    }

    public void rotateEdge(int[][] matrix, int leftRow, int leftCol, int rightRow, int rightCol) {
        for (int i = leftRow; i <= rightRow - 1; i++) {
            int temp = matrix[leftRow][leftCol + i];
            matrix[leftRow][leftCol + i] = matrix[leftRow + i][rightCol];
            matrix[leftRow + i][rightCol] = matrix[rightRow - i][rightCol];
            matrix[rightRow - i][rightCol] = matrix[leftRow + i][rightCol];
            matrix[leftRow + i][rightCol] = temp;
        }
    }

    @Test
    public void test(){
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
