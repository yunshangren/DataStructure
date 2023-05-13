package solution11;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/5/5 15:03
 */
public class AtMostNGivenDigitSet {

    char[] chars;
    int[] memo;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        chars = String.valueOf(n).toCharArray();
        memo = new int[chars.length];
        Arrays.fill(memo, -1);
        return dfs(0, digits, true, false);
    }

    public int dfs(int index, String[] digits, boolean isLimit, boolean isNum) {
        if (index == chars.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[index] != -1)
            return memo[index];
        int res = 0;
        if (!isNum) {
            res += dfs(index + 1, digits, false, false);
        }
        int top = chars[index] - '0';
        for (String digit : digits) {
            int num = Integer.parseInt(digit);
            if (isLimit && num > top) {
                break;
            } else {
                res += dfs(index + 1, digits, isLimit && num == top, true);
            }
        }
        if (!isLimit && isNum) {
            memo[index] = res;
        }
        return res;
    }

    @Test
    public void test() {
        String[] digits = {"1", "3", "5", "7", "8"};
        System.out.println(atMostNGivenDigitSet(digits, 800));
    }
}
