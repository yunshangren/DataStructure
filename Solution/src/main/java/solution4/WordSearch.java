package solution4;

/**
 * @author Acer
 * @create 2023/3/3 16:42
 */
public class WordSearch {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, visited, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, int index) {

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[row][col] = true;
        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];
            if (dfs(board, visited, word, x, y, index + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }


}
