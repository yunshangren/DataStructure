package solution7;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/23 9:30
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = Integer.MIN_VALUE;
        int[] count = new int[26];
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int index = s.charAt(right++) - 'a';
            count[index]++;
            while (count[index] > 1) {
                count[s.charAt(left++) - 'a']--;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    @Test
    public void test() {
        String s = "pwwkewbs";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
