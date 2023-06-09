package solution10;

import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/16 18:58
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else if (j == 0) {
                    dp[j] += triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp) {
            min = Math.min(min, i);
        }
        return min;
    }
}
