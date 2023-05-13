package solution.backtrack;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/1 19:17
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean[] success = new boolean[1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, success, new StringBuilder(), visited, word, i, j, 0);
                if (success[0]) {
                    break;
                }
            }
        }
        backtrack(board, success, new StringBuilder(), visited, word, 0, 0, 0);
        return success[0];
    }

    public void backtrack(char[][] board, boolean[] success, StringBuilder builder, boolean[][] visited, String word, int row, int col, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || (builder.length() == word.length() && !word.equals(builder.toString()))) {
            return;
        }
        if (index > word.length() || board[row][col] != word.charAt(index) || success[0]) {
            return;
        }

        builder.append(board[row][col]);
        if (word.equals(builder.toString())) {
            success[0] = true;
            return;
        }

        visited[row][col] = true;
        backtrack(board, success, builder, visited, word, row - 1, col, index + 1);
        backtrack(board, success, builder, visited, word, row + 1, col, index + 1);
        backtrack(board, success, builder, visited, word, row, col - 1, index + 1);
        backtrack(board, success, builder, visited, word, row, col + 1, index + 1);

        builder.deleteCharAt(builder.length() - 1);
        visited[row][col] = false;
    }

    @Test
    public void test() {
        char[][] board = {
                {'b', 'a', 'b'},
                {'b', 'b', 'a'},
                {'b', 'b', 'b'},
        };
        String word = "ab";
        System.out.println(exist(board, word));
    }
}
