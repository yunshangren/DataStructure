package solution5;

/**
 * @author Acer
 * @create 2023/3/8 10:40
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j < n + 1; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 1. 删除c1，使得word1[0 : i - 1] == word2[0 : j] 即 dp[i - 1][j] + 1;
                    // 2. 删除c2，使得word1[0 : i] == word2[0 : j - 1] 即 dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
