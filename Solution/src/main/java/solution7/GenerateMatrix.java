package solution7;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/24 17:49
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cur = 1;
        int leftRow = 0;
        int leftCol = 0;
        int rightRow = n - 1;
        int rightCol = n - 1;
        while (leftRow < rightRow && leftCol < rightCol) {
            for (int i = leftCol; i < rightCol; i++) {
                res[leftRow][i] = cur++;
            }
            for (int i = leftRow; i < rightRow; i++) {
                res[i][rightCol] = cur++;
            }
            for (int i = rightCol; i > leftCol; i--) {
                res[rightRow][i] = cur++;
            }
            for (int i = rightRow; i > leftRow; i--) {
                res[i][leftCol] = cur++;
            }
            leftRow++;
            leftCol++;
            rightRow--;
            rightCol--;
        }
        if (leftRow == rightRow) {
            res[leftRow][leftCol] = cur;
        }
        return res;
    }

    @Test
    public void test() {
        int[][] matrix = generateMatrix(4);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }

    }
}
