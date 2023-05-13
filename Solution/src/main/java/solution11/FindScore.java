package solution11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Acer
 * @create 2023/5/11 19:55
 */
public class FindScore {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] mat = new int[n][2];
        for (int i = 0; i < n; i++) {
            mat[i][0] = i; // 原坐标
            mat[i][1] = nums[i]; // 值
        }
        Arrays.sort(mat, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[][] index = new int[n][2];
        for (int i = 0; i < n; i++) {
            index[i][0] = i;
            index[i][1] = mat[i][0];
        }
        Arrays.sort(index, Comparator.comparingInt(o -> o[1]));
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (mat[i][1] == 0) {
                continue;
            }
            sum += mat[i][1];
            mat[i][1] = 0;
            int idx = mat[i][0];
            if (idx > 0) {
                mat[index[idx - 1][0]][1] = 0;
            }
            if (idx < n - 1) {
                mat[index[idx + 1][0]][1] = 0;
            }
        }
        return sum;
    }
}
