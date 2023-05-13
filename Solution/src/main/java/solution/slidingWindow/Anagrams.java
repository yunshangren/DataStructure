package solution.slidingWindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author Acer
 * @create 2022/10/18 21:03
 */
public class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        char[] arr = s.toCharArray();
        while (right < s.length()) {
            char c = arr[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                char d = arr[left];
                if (valid == need.size()) {
                    res.add(left);
                }
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(need.get(d), window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        return res;
    }

    @Test
    public void test() {
        String s1 = "cbaebabacd";
        String s2 = "abc";
        List<Integer> anagrams = findAnagrams(s1, s2);
        System.out.println(anagrams);
    }

}
