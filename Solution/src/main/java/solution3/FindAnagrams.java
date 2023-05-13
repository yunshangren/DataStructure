package solution3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2023/2/24 9:21
 */
public class FindAnagrams {
    // 找到字符串中所有字母异位词
    // 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        int[] sArr = new int[26];
        // 左闭右开
        while (right < s.length()) {
            sArr[s.charAt(right++) - 'a']++;
            while (right - left >= p.length()) {
                if (Arrays.equals(sArr, pArr)) {
                    res.add(left);
                }
                sArr[s.charAt(left++) - 'a']--;
            }

        }
        return res;
    }

    @Test
    public void test() {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }
}
