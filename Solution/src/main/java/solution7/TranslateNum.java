package solution7;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/23 9:15
 */
public class TranslateNum {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] += dp[i - 1];
            int temp = Integer.parseInt(s.substring(i - 2, i));
            if (temp > 9 && temp < 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(translateNum(506));
    }
}
