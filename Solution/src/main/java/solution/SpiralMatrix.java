package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2022/10/18 19:07
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int leftRow = 0;
        int leftCol = 0;
        int rightRow = matrix.length - 1;
        int rightCol = matrix[0].length - 1;

        while (leftRow <= rightRow && leftCol <= rightCol) {
            if(leftRow == rightRow){
                for (int i = leftCol; i <= rightCol; i++) {
                    res.add(matrix[leftRow][i]);
                }
                return res;
            }
            if(leftCol == rightCol){
                for (int i = leftRow; i <= rightRow; i++) {
                    res.add(matrix[i][leftCol]);
                }
                return res;
            }
            for (int i = leftCol; i < rightCol; i++) {
                res.add(matrix[leftRow][i]);
            }
            for (int i = leftRow; i < rightRow; i++) {
                res.add(matrix[i][rightCol]);
            }
            for (int i = rightCol; i > leftCol; i--) {
                res.add(matrix[rightRow][i]);
            }
            for (int i = rightRow; i > leftRow; i--) {
                res.add(matrix[i][leftCol]);
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
                {1,11},
                {2,12},
                {3,13},
                {4,14},
                {5,15},
                {6,16},
                {7,17},
                {8,18},
                {9,19},
                {10,20},
        };
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }

}


