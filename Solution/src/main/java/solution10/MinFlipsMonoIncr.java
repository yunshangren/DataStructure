package solution10;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/14 15:41
 */
public class MinFlipsMonoIncr {
    public int minFlipsMonoIncr1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][2];
        dp[0][0] = chars[0] - '0';
        dp[0][1] = chars[0] == '1' ? 0 : 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + (chars[i] == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (chars[i] == '1' ? 0 : 1);
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public int minFlipsMonoIncr2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res0 = chars[0] == '0' ? 0 : 1;
        int res1 = chars[0] == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            int temp0 = res0 + (chars[i] == '0' ? 0 : 1);
            int temp1 = Math.min(res0, res1) + (chars[i] == '1' ? 0 : 1);
            res0 = temp0;
            res1 = temp1;
        }
        return Math.min(res0, res1);
    }

    @Test
    public void test() {
        String s = "010110";
        System.out.println(minFlipsMonoIncr1(s));
    }
}
