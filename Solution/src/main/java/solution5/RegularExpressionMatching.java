package solution5;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/13 18:42
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < m + 1; i++) {
            char c1 = s.charAt(i - 1);
            for (int j = 1; j < n + 1; j++) {
                char c2 = p.charAt(j - 1);
                if (c1 == c2 || c2 == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    if (p.charAt(j - 2) == c1 || p.charAt(j - 2) == '.') {
                        // 1. 重复0次，即删除前一个 dp[i][j] = dp[i][j - 2];
                        // 2. 重复1次， dp[i][j] = dp[i - 1][j - 2];
                        // 2. 重复2次及以上， dp[i][j] = dp[i - 1][j];
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }
}
