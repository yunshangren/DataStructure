package solution7;

/**
 * @author Acer
 * @create 2023/3/27 13:22
 */
public class LCOF {
    boolean[][] visited;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || visited[row][col]
                || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        for (int[] direction : directions) {
            if (backtrack(board, word, index + 1, row + direction[0], col + direction[1])) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }


}
