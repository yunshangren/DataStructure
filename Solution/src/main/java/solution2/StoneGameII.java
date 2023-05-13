package solution2;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/22 13:22
 */
public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int[] preSum = new int[piles.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + piles[i - 1];
        }
        int[][] memo = new int[preSum.length][preSum.length];
        process(piles, preSum, memo, 0, 1);
        return memo[0][1];
    }

    public int process(int[] piles, int[] preSum, int[][] memo, int startIndex, int m) {
        if (startIndex >= preSum.length) {
            return 0;
        }
        if (memo[startIndex][m] != 0) {
            return memo[startIndex][m];
        }
        int maxStones = 0;
        for (int i = 1; i <= 2 * m; i++) {
            int secondMaxStones = process(piles, preSum, memo, startIndex + i, Math.max(i, m));
            maxStones = Math.max(maxStones, preSum[piles.length] - preSum[startIndex] - secondMaxStones);
        }
        return memo[startIndex][m] = maxStones;

    }

    public int dfs(int[] piles, int[] preSum, int startIndex, int m) {

        if (startIndex >= preSum.length) {
            return 0;
        }
        int maxStones = 0;
        for (int i = 1; i <= 2 * m; i++) {
            int secondMaxStones = dfs(piles, preSum, startIndex + i, Math.max(i, m));
            maxStones = Math.max(maxStones, preSum[piles.length] - preSum[startIndex] - secondMaxStones);
        }
        return maxStones;
    }


    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 100};
        System.out.println(stoneGameII(arr));
    }
}
