package solution8;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/29 15:22
 */
public class CountVowelStrings {
    public int countVowelStrings(int n) {
        int[] dp = new int[6];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 6; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[5];
    }

    @Test
    public void test(){
        System.out.println(countVowelStrings(33));
    }
}
