package solution12;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Acer
 * @create 2023/5/15 10:41
 */
public class MaxEqualRowsAfterFlips {
    static class Row {
        int[] row;

        public Row(int[] row) {
            this.row = row;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Row)) return false;
            Row row = (Row) o;
            return Arrays.equals(this.row, row.row);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(row);
        }
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // 等价行最多的个数
        HashMap<Row, Integer> map = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] ^= 1;
                }
            }
            Row row = new Row(matrix[i]);
            max = Math.max(max, map.merge(row, 1, Integer::sum));
        }
        return max;
    }


}
