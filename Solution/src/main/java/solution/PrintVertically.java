package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2022/11/2 14:31
 */
public class PrintVertically {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        String[] strings = s.split(" ");
        int maxLen = 0;

        for (String string : strings) {
            maxLen = Math.max(maxLen, string.length());
        }
        for (int i = 0; i < maxLen; i++) {
            StringBuilder builder = new StringBuilder();
            for (String str : strings) {
                if (str.length() > i) {
                    builder.append(str.charAt(i));
                } else {
                    builder.append(" ");
                }
            }
            // 删除不需要的空格
            while (builder.charAt(builder.length() - 1) == ' ') {
                builder.deleteCharAt(builder.length() - 1);
            }
            res.add(builder.toString());
        }

        return res;
    }

    @Test
    public void test() {
        String s = "AA BBB C DDDD EEEEE F";
        List<String> list = printVertically(s);
        for (String s1 : list) {
            System.out.println(s1);
        }


    }
}
