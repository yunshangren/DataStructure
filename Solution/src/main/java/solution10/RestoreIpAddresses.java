package solution10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/14 13:32
 */
public class RestoreIpAddresses {
    List<String> res = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        dfs(s.toCharArray(), 0, 0);
        return res;
    }


    public void dfs(char[] chars, int dots, int index) {
        if (dots == 4) {
            if (index == chars.length) {
                StringBuilder temp = new StringBuilder(builder);
                temp.deleteCharAt(temp.length() - 1);
                res.add(temp.toString());
            }
            return;
        }
        for (int i = 0; i < 3 && index + i < chars.length; i++) {
            if (chars[index] == '0') {
                builder.append('0');
                builder.append('.');
                dfs(chars, dots + 1, index + 1);
                builder.delete(builder.length() - 2, builder.length());
                break;
            } else {
                int temp = Integer.parseInt(new String(chars, index, i + 1));
                if (temp < 256) {
                    builder.append(temp);
                    builder.append('.');
                    dfs(chars, dots + 1, index + i + 1);
                    builder.delete(builder.length() - i - 2, builder.length());
                }
            }
        }
    }


    @Test
    public void test() {
        String s = "010010";
        System.out.println(restoreIpAddresses(s));
    }
}
