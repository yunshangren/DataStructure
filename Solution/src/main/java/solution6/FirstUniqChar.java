package solution6;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author Acer
 * @create 2023/3/18 12:00
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Set<Character> keySet = map.keySet();
        for (Character c : keySet) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cnt[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }

    @Test
    public void test() {
        String str = "leetcode";
        System.out.println(firstUniqChar(str));
    }
}
