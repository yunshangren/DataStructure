package solution9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/6 16:33
 */
public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            StringBuilder builder = new StringBuilder();
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i : count) {
                builder.append(i);
                builder.append(",");
            }
            String key = builder.toString();
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(key, temp);
            }
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    public int mask(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            mask |= (1 << (c - 'a'));
        }
        return mask;
    }

    @Test
    public void test() {
        String[] strs = {"bdddddddddd", "bbbbbbbbbbc"};
        System.out.println(groupAnagrams(strs));
    }
}
