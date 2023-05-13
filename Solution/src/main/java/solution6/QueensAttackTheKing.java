package solution6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/3/21 14:23
 */
public class QueensAttackTheKing {
    public List<List<Integer>> queensAttackTheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new LinkedList<>();
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        boolean[][] hasQueen = new boolean[8][8];
        for (int[] queen : queens) {
            hasQueen[queen[0]][queen[1]] = true;
        }

        for (int[] direction : directions) {
            int row = king[0];
            int col = king[1];
            int i = direction[0];
            int j = direction[1];
            while (row >= 0 && row < 8 && col >= 0 && col < 8) {
                if (hasQueen[row][col]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(row);
                    list.add(col);
                    res.add(list);
                    break;
                } else {
                    row += i;
                    col += j;
                }
            }
        }
        return res;
    }
}
