package solution.dp;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/4 14:23
 */
public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] p1 = new int[n][n];
        int[][] p2 = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    p1[i][j] = nums[i];
                    p2[i][j] = 0;
                    continue;
                }
                p1[i][j] = Math.max(nums[i] + p2[i + 1][j], nums[j] + p2[i][j - 1]);
                p2[i][j] = Math.min(p1[i + 1][j], p1[i][j - 1]);
            }
        }
        return p1[0][n - 1] >= p2[0][n - 1];

    }

    // 先手玩家能够获得的最大分数
    public int first(int[] nums, int i, int j) {
        if (i == j) {
            // 如果只有一个数，先手玩家可以获得这个分数
            return nums[i];
        }

        return Math.max(
                nums[i] + next(nums, i + 1, j),
                nums[j] + next(nums, i, j - 1)
        );
    }

    // 后手玩家能够获得的最大分数
    public int next(int[] nums, int i, int j) {
        if (i == j) {
            // 如果只有一个数，会被先手玩家获得，后手玩家获得0
            return 0;
        }
        return Math.min(
                first(nums, i + 1, j),
                first(nums, i, j - 1)
        );
    }

    @Test
    public void test() {
        int[] arr = {1, 5, 2};
        System.out.println(predictTheWinner(arr));
    }
}
