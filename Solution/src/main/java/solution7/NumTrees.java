package solution7;

/**
 * @author Acer
 * @create 2023/3/27 15:23
 */
public class NumTrees {
    public int numTrees(int n) {
        int[][] memo = new int[n + 1][n + 1];
        return count(1, n, memo);
    }

    public int count(int left, int right, int[][] memo) {
        if (left < right) {
            return 1;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            int leftCount = count(left, i - 1, memo);
            int rightCount = count(i + 1, right, memo);
            res += leftCount * rightCount;
        }
        return memo[left][right] = res;
    }
}
