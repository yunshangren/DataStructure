package solution8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Acer
 * @create 2023/4/4 16:11
 */
public class LongestStrChain {
    int[] memo;

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        memo = new int[words.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            res = Math.max(res, dfs(words, i));
        }
        return res;
    }

    public int dfs(String[] words, int index) {
        if (index == words.length) {
            return 0;
        }
        if (memo[index] > 0) {
            return memo[index];
        }
        int res = 1;
        String pre = words[index];
        for (int i = index + 1; i < words.length; i++) {
            String cur = words[i];
            int temp = 1;
            if (check(pre, cur)) {
                temp += memo[i] > 0 ? memo[i] : dfs(words, i);
            }
            res = Math.max(res, temp);
        }
        memo[index] = res;
        return res;
    }

    public boolean check(String pre, String cur) {
        if (cur.length() - pre.length() != 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < pre.length()) {
            if (pre.charAt(i) == cur.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }
        j++;
        while (i < pre.length()) {
            if (pre.charAt(i) != cur.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    @Test
    public void test() {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(longestStrChain(words));
    }
}
