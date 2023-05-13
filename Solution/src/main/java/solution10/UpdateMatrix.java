package solution10;

import org.junit.Test;

import java.util.*;

/**
 * @author Acer
 * @create 2023/4/17 15:11
 */
public class UpdateMatrix {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public int[][] updateMatrix2(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                for (int[] direction : directions) {
                    int x = arr[0] + direction[0];
                    int y = arr[1] + direction[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        mat[x][y] = level;
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            level++;
        }
        return mat;
    }

    @Test
    public void test() {
        int[][] mat = {
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0},
        };
        System.out.println(Arrays.deepToString(updateMatrix2(mat)));

    }
}
