package solution;

/**
 * @author Acer
 * @create 2022/11/3 10:46
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowFlag = false;
        boolean colFlag = false;
        // 第一行有没有0
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }
        // 第一列有没有0
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                colFlag = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowFlag){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if(colFlag){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
