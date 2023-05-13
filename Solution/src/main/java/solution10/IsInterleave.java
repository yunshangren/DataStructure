package solution10;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/16 16:37
 */
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < m + 1; i++) {
            char c = s1.charAt(i - 1);
            for (int j = 1; j < n + 1; j++) {
                char d = s2.charAt(j - 1);
                char e = s3.charAt(i + j - 1);
                dp[i][j] = ((c == e && dp[i - 1][j]) || (d == e && dp[i][j - 1]));
            }
        }
        return dp[m][n];

    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 || j == 1) {
                    if (i == 1 && j == 1) {
                        dp[i][j] = grid[0][0];
                    } else if (i == 1) {
                        dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        String s = "adbcc";
        String t = "abbca";
        String target = "aadbbcbcac";
        System.out.println(isInterleave(s, t, target));
    }
}
