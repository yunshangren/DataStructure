package solution8;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/31 15:45
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int[] arr = new int[100];
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            arr[c - ' ']++;
            while (arr[c - ' '] > 1) {
                if (right - left > res) {
                    res = right - left;
                }
                char d = s.charAt(left++);
                arr[d - ' ']--;
            }
            right++;
        }
        return Math.max(res, right - left);
    }

    @Test
    public void test() {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
