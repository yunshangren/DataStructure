package solution9;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/7 14:21
 */
public class IsUnique {
    public boolean isUnique(String astr) {
        if (astr.length() > 26) {
            return false;
        }
        int mask = 0;
        for (char c : astr.toCharArray()) {
            int div = c - 'a';
            if ((mask & (1 << div)) != 0) {
                return false;
            }
            mask |= 1 << div;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "leetcode";
        System.out.println(isUnique(s));
    }
}
