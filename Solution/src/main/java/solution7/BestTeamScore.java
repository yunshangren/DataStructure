package solution7;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/3/22 10:23
 */
public class BestTeamScore {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        // arr[i][0] ---> score
        // arr[i][1] ---> age
        for (int i = 0; i < n; i++) {
            arr[i][0] = scores[i];
            arr[i][1] = ages[i];
        }
        Arrays.sort(arr, (o1, o2) -> {
            // 按照分数升序，分数相同时，按照年龄升序
            return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
        });

        int[] dp = new int[n];
        int best = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // i.score >= j.score;
                // if(i.age >= j.age) i即可入队
                if (dp[i] < dp[j] && arr[i][1] >= arr[j][1]) {
                    dp[i] = dp[j];
                }
            }
            dp[i] += arr[i][0];
            best = Math.max(best, dp[i]);
        }
        return best;
    }

    @Test
    public void test() {
        int[] scores = {4, 5, 6, 5, 5};
        int[] ages = {2, 1, 2, 1, 3};
        System.out.println(bestTeamScore(scores, ages));
    }
}
