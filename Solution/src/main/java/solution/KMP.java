package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/3 9:16
 */
public class KMP {

    public int maxRepeating(String sequence, String word) {
        int res = 0;
        String subStr = word;
        while (strStr(sequence, subStr) != -1) {
            subStr += word;
            res++;
        }
        return res;
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() < 1 || haystack.length() < needle.length()) {
            return -1;
        }
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();
        int[] next = getNextArray(s2);

        int i1 = 0;
        int i2 = 0;
        while (i1 < haystack.length() && i2 < needle.length()) {
            if (s1[i1] == s2[i2]) {
                i1++;
                i2++;
            } else if (i2 > 0) {
                i2 = next[i2];
            } else {
                i1++;
            }
        }

        // i1 或者 i2 越界

        return i2 == needle.length() ? i1 - i2 : -1;
    }

    public int[] getNextArray(char[] str) {
        if (str == null) {
            return null;
        }
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        // 人为规定，0位置取-1,1位置为0
        next[0] = -1;
        next[1] = 0;
        // i位置的信息怎么求？
        // 如果next[i - 1]位置的字符和i - 1 位置的字符一样，那next[i] = next[i - 1] + 1;
        // 如果不一样，那就看next[next[i - 1]]位置的字符和i - 1 位置的信息是否一样
        // 在这个过程中，如果next[i-1] 如果已经为0，就看0位置的字符和i-1位置的字符是否一样，一样就是1，否则就是0
        int index = 2;
        int cur = next[index - 1];
        while (index < str.length) {
            if (str[index - 1] == str[cur]) {
                next[index++] = ++cur;
            } else if (cur > 0) {
                cur = next[cur];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

    @Test
    public void test() {
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";
        System.out.println(maxRepeating(sequence, word));
    }
}
