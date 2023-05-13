package solution3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2023/2/27 16:27
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        // 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] arr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                bfs(board, arr, visited, 0, i);
            }
        }
        for (int i = 1; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                bfs(board, arr, visited, i, n - 1);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (board[m - 1][i] == 'O') {
                bfs(board, arr, visited, m - 1, i);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                bfs(board, arr, visited, i, 0);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(char[][] board, int[][] arr, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] num = queue.poll();
                for (int[] ints : arr) {
                    int row = num[0] + ints[0];
                    int col = num[1] + ints[1];
                    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                            || visited[row][col] || board[row][col] == 'X') {
                        continue;
                    }
                    queue.add(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
    }
}
