package solution10;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/13 19:35
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        int[] need = new int[100];
        int[] window = new int[100];
        int count = 0;
        for (char c : t.toCharArray()) {
            if (need[c - 'A']++ == 0) {
                count++;
            }
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        while (right < n) {
            int index1 = chars[right++] - 'A';
            if (need[index1] > 0) {
                window[index1]++;
                if (window[index1] == need[index1]) {
                    count--;
                }
            }
            while (count == 0) {
                int index2 = chars[left] - 'A';
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }
                left++;
                if (window[index2] > 0) {
                    window[index2]--;
                    if (window[index2] < need[index2]) {
                        count++;
                    }
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }

    @Test
    public void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
