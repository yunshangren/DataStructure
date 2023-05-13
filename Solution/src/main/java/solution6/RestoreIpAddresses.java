package solution6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/3/21 16:22
 */
public class RestoreIpAddresses {
    List<String> res;
    StringBuilder builder;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s.length() < 4) {
            return res;
        }
        return res;
    }

    public void backtrack(String s, int startIndex, int cnt) {
        if (cnt == 3 && Integer.parseInt(s.substring(startIndex)) < 256) {
            res.add(builder.toString());
            return;
        }
        for (int i = startIndex; i < s.length() - 1; i++) {

        }
    }
}
