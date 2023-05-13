package solution11;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/5/5 14:49
 */
public class CountSpecialNumbers {
    char[] chars;
    int[][] memo;

    public int countSpecialNumbers(int n) {
        chars = String.valueOf(n).toCharArray();
        memo = new int[chars.length][1024];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, 0, true, false);
    }

    public int dfs(int index, int mask, boolean isLimit, boolean isNum) {
        if (index == chars.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[index][mask] != -1) {
            return memo[index][mask];
        }
        int res = 0;
        if (!isNum) {
            res += dfs(index + 1, mask, false, false);
        }
        int top = isLimit ? chars[index] - '0' : 9;
        for (int i = isNum ? 0 : 1; i <= top; i++) {
            if ((mask & (1 << i)) == 0) {
                res += dfs(index + 1, mask | (1 << i), isLimit && i == top, true);
            }
        }
        if (!isLimit && isNum) {
            memo[index][mask] = res;
        }
        return res;
    }
}
