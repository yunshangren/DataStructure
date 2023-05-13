package solution.dp;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Acer
 * @create 2022/11/6 16:37
 */
public class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] zerosOnes = getZerosOnes(strs);
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int zeros = zerosOnes[i - 1][0];
            int ones = zerosOnes[i - 1][1];
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(1 + dp[i - 1][j - zeros][k - ones], dp[i][j][k]);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int[][] getZerosOnes(String[] strs) {
        int[][] zerosOnes = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int cnt0 = 0;
            int cnt1 = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
            zerosOnes[i][0] = cnt0;
            zerosOnes[i][1] = cnt1;
        }
        return zerosOnes;
    }

    public int process(String[] strs, int m, int n, int step, HashMap<Integer, int[]> map) {

        if (step == strs.length - 1) {
            return m >= map.get(step)[0] && n >= map.get(step)[1] ? 1 : 0;
        }
        int temp = m >= map.get(step)[0] && n >= map.get(step)[1] ? 1 : 0;
        if (temp == 0) {
            return process(strs, m, n, step + 1, map);
        } else {
            return Math.max(
                    1 + process(strs, m - map.get(step)[0], n - map.get(step)[1], step + 1, map),
                    process(strs, m, n, step + 1, map)
            );
        }
    }

    @Test
    public void test() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));
    }
}
