package solution.slidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author Acer
 * @create 2022/10/17 14:25
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0; // window的左边界
        int right = 0; // window的右边界
        int startIndex = 0; // 最小覆盖子串的起始下标
        int len = Integer.MAX_VALUE; // 满足条件的字串的长度
        int cnt = 0; // window中符合条件的记录数
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    cnt++;
                }
            }
            while (cnt == need.size()) {
                char d = s.charAt(left);
                if (right - left < len) {
                    len = right - left;
                    startIndex = left;
                }
                left++;
                if (window.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    if (window.get(d) < need.get(d)) {
                        cnt--;
                    }

                }

            }

        }
        System.out.println("startIndex = " + startIndex);
        System.out.println("len = " + len);
        return len == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + len);
    }

    @Test
    public void test() {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(minWindow(s, t));
    }

}
