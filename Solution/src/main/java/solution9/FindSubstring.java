package solution9;

import org.junit.Test;

import java.util.*;

/**
 * @author Acer
 * @create 2023/4/6 21:00
 */
public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int len = words[0].length();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int left = 0;
        int right = words.length * len;
        if (s.length() < right) {
            return res;
        }

        while (right <= s.length()) {
            String temp = s.substring(left, right);
            HashMap<String, Integer> tempMap = new HashMap<>();
            for (int i = 0; i < temp.length(); i += len) {
                String key = temp.substring(i, i + len);
                tempMap.put(key, tempMap.getOrDefault(key, 0) + 1);
            }
            if (map.equals(tempMap)) {
                res.add(left);
            }
            left++;
            right++;
        }
        return res;
    }




    @Test
    public void test() {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));

    }
}
