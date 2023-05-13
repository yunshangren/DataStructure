package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/27 19:03
 */
public class FindNumberInMatrix {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            int cur = matrix[row][col];
            if(cur == target){
                return true;
            }else if(cur < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[][] matrix = {
        };
        System.out.println(findNumberIn2DArray(matrix,-5));
    }
}
