package solution5;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/13 16:44
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        char[] chars = new char[(n << 1) + 1];
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                chars[i] = '#';
            } else {
                chars[i] = s.charAt(i >> 1);
            }
        }

        int res = 0;
        for (int i = 1; i < chars.length - 1; i++) {
            int len = 1;
            while (i - len >= 0 && i + len < chars.length) {
                if (chars[i - len] == chars[i + len]) {
                    len++;
                } else {
                    break;
                }
            }
            res += len >> 1;
        }
        return res;
    }

    @Test
    public void test() {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }
}
