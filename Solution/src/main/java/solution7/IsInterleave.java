package solution7;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/24 18:57
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
        for (int i = 1; i < n + 1; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < m + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }

    @Test
    public void test(){
        String s1 = "aacaac";
        String s2 = "aacaaeaac";
        String s3 = "aacaaeaaeaacaac";
        System.out.println(isInterleave(s1,s2,s3));
    }
}
