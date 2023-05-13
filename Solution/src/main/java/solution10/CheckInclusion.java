package solution10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/13 19:06
 */
public class CheckInclusion {
    public boolean checkInclusion1(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        int left = 0;
        int right = m;
        while (right <= n) {
            if (check(s1, s2.substring(left++, right++))) {
                return true;
            }
        }
        return false;
    }

    public boolean check(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count2[c - 'a']++;
        }
        return Arrays.equals(count1, count2);
    }

    public boolean checkInclusion2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        int[] count1 = new int[26];
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        int left = 0;
        int right = m;
        int[] count2 = new int[26];
        for (int i = 0; i < m; i++) {
            count2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count1, count2)) {
            return true;
        }
        while (right < n) {
            count2[s2.charAt(left++) - 'a']--;
            count2[s2.charAt(right++) - 'a']++;
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        if (m > n) {
            return res;
        }
        int[] count1 = new int[26];
        for (char c : p.toCharArray()) {
            count1[c - 'a']++;
        }
        int left = 0;
        int right = m;
        int[] count2 = new int[26];
        for (int i = 0; i < m; i++) {
            count2[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count1, count2)) {
            res.add(left);
        }
        while (right < n) {
            count2[s.charAt(left++) - 'a']--;
            count2[s.charAt(right++) - 'a']++;
            if (Arrays.equals(count1, count2)) {
                res.add(left);
            }
        }
        return res;
    }

    @Test
    public void test() {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion2(s1, s2));
    }
}
