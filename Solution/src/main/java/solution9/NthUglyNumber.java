package solution9;

/**
 * @author Acer
 * @create 2023/4/11 13:56
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        int p2, p3, p5;
        p2 = p3 = p5 = 1;
        int pro2 = 2;
        int pro3 = 3;
        int pro5 = 5;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.min(pro2, Math.min(pro3, pro5));
            if (dp[i] == pro2) {
                pro2 = 2 * dp[++p2];
            }
            if (dp[i] == pro3) {
                pro3 = 3 * dp[++p3];
            }
            if (dp[i] == pro5) {
                pro5 = 5 * dp[++p5];
            }
        }
        return dp[n];
    }
}
