package solution.dp;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/4 10:30
 */
public class NumDecodings {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] >= '1' && chars[i] <= '9') {
                dp[i] += dp[i - 1];
            }
            int num = Integer.parseInt(new String(chars, i - 1, 2));
            if (num >= 10 && num <= 26) {
                dp[i] += i > 1 ? dp[i - 2] : 1;
            }
        }
        return dp[len - 1];
    }

    @Test
    public void test() {
        char[] chars = {'0','1','2'};
        int num = Integer.parseInt(new String(chars, 0, 2));
        System.out.println(num);

        String s = "06";
        System.out.println(numDecodings(s));

    }
}
