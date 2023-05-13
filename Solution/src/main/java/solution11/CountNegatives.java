package solution11;

import org.junit.Test;
import tool.Tools;

/**
 * @author Acer
 * @create 2023/5/11 14:15
 */
public class CountNegatives {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (col > 0 && grid[row][col - 1] < 0) {
                col--;
            } else {
                count += col == n - 1 ? grid[row][col] < 0 ? 1 : 0 : n - col;
                row++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        String s = "[[4,3,2,1],[3,2,1,-1],[1,1,-1,-2],[0,-1,-2,-3]]";
        int[][] mat = Tools.stringToMatrix(s);
        System.out.println(countNegatives(mat));
    }
}
