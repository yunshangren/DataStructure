package solution4;

/**
 * @author Acer
 * @create 2023/3/1 13:39
 */
public class LargestLocal {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                res[i][j] = getLargest(grid, i, j);
            }
        }
        return res;
    }

    public int getLargest(int[][] matrix, int row, int col){
        int max = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }
}
