package solution7;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/24 15:17
 */
public class WildcardMatching {
    //'?' 可以匹配任何单个字符。
    //'*' 可以匹配任意字符串(包括空字符串)
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < m + 1; i++) {
            char c = s.charAt(i - 1);
            for (int j = 1; j < n + 1; j++) {
                char d = p.charAt(j - 1);
                if (c == d || d == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (d == '*' && (dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }
    @Test
    public void test(){
        String s = "adceb";
        String p = "*a*b";
        System.out.println(isMatch(s,p));
    }
}
