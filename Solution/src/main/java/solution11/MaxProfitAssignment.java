package solution11;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Acer
 * @create 2023/4/27 15:20
 */
public class MaxProfitAssignment {
    // difficulty[i]表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
    // worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
    // 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        int sum = 0;
        for (int i : worker) {
            int temp = 0;
            for (int j = 0; j < difficulty.length; j++) {
                if (i >= difficulty[j]) {
                    temp = Math.max(temp, profit[j]);
                }
            }
            sum += temp;
        }
        return sum;

    }

    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int m = difficulty.length;
        int[][] matrix = new int[m][2];
        for (int i = 0; i < m; i++) {
            matrix[i][0] = difficulty[i];
            matrix[i][1] = profit[i];
        }
        Arrays.sort(matrix, (Comparator.comparingInt(o -> o[0])));
        for (int i = 1; i < m; i++) {
            matrix[i][1] = Math.max(matrix[i][1], matrix[i - 1][1]);
        }
        Arrays.sort(worker);
        int sum = 0;
        int index = 0;
        for (int i : worker) {
            if (i >= matrix[0][0]) {
                index = binarySearch(matrix, i, index);
                sum += matrix[index][1];
            }
        }
        return sum;
    }

    public int binarySearch(int[][] matrix, int target, int left) {

        int right = matrix.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] difficulty = {23, 30, 35, 35, 43, 46, 47, 81, 83, 98};
        int[] profit = {8, 11, 11, 20, 33, 37, 60, 72, 87, 95};
        int[] worker = {95, 46, 47, 97, 11, 35, 99, 56, 41, 92};
        System.out.println(maxProfitAssignment1(difficulty, profit, worker));
        System.out.println(maxProfitAssignment2(difficulty, profit, worker));
    }
}
