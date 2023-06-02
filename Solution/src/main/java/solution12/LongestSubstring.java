package solution12;

/**
 * @author Acer
 * @create 2023/6/1 13:43
 */
public class LongestSubstring {
    // 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，
    // 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
    
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] < k) {
                int res = 0;
                char c = 'a';
                c += i;
                // 如果一个字符出现的次数在(0,k)区间，说明包含这个字符的所有字串都不是要找的字串
                // 以这个字符分割原字符串，在所有的字串中去找可能的答案
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
