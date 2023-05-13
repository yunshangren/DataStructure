package solution7;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Acer
 * @create 2023/3/27 18:55
 */
public class SortSentence {
    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        for (String str : strs) {
            map.put(str.charAt(str.length() - 1), str.substring(0, str.length() - 1));
        }
        StringBuilder builder = new StringBuilder();
        for (char c = '1'; c <= '9' && map.get(c) != null; c++) {
            builder.append(map.get(c));
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    @Test
    public void test() {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }
}
