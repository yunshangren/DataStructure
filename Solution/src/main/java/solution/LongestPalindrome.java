package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/28 20:21
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] chars = new char[(s.length() << 1) + 1];
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                chars[i] = '#';
            } else {
                chars[i] = s.charAt((i - 1) >> 1);
            }
        }
        int maxLen = 1;
        int center = -1;
        for (int i = 1; i < chars.length; i++) {
            int len = 1;
            int curLen = 1;
            while (i - len >= 0 && i + len < chars.length && chars[i - len] == chars[i + len]) {
                curLen += 2;
                len++;
            }
            if (curLen > maxLen) {
                center = i;
                maxLen = curLen;
            }

        }
        center = (center - 1) / 2;
        maxLen = (maxLen - 1) / 2;
        int startIndex = center - (maxLen - 1) / 2;
        return s.substring(startIndex,startIndex + maxLen);
    }

    @Test
    public void test() {
        String s = "babad";
        System.out.println(s.substring(0,3));
        System.out.println(longestPalindrome(s));
    }
}
