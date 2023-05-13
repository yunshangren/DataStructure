package solution10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/14 13:07
 */
public class PalindromePartition {
    List<List<String>> list = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public String[][] partition(String s) {
        char[] chars = s.toCharArray();
        dfs(chars, 0);
        String[][] res = new String[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i).toArray(new String[list.get(i).size()]);
        }
        return res;
    }

    public void dfs(char[] chars, int index) {
        if (index == chars.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < chars.length - index; i++) {
            if (isPalindrome(chars, index, index + i)) {
                path.add(new String(chars, index, i + 1));
                dfs(chars, index + i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s = "google";
        System.out.println(Arrays.deepToString(partition(s)));
    }
}
