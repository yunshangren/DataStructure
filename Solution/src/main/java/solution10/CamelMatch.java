package solution10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/14 10:47
 */
public class CamelMatch {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            res.add(isMath(query, pattern));
        }
        return res;
    }

    public boolean isMath(String query, String pattern) {
        if (query.length() < pattern.length()) {
            return false;
        }
        if (query.equals(pattern)) {
            return true;
        }
        int p1 = 0;
        int p2 = 0;
        while (p1 < query.length() && p2 < pattern.length()) {
            if (query.charAt(p1) == pattern.charAt(p2)) {
                p2++;
            } else if (query.charAt(p1) >= 'A' && query.charAt(p1) <= 'Z') {
                return false;
            }
            p1++;
        }
        if (p2 == pattern.length()) {
            while (p1 < query.length()) {
                char c = query.charAt(p1);
                if (c >= 'A' && c <= 'Z') {
                    return false;
                }
                p1++;
            }
            return true;
        }
        return false;
    }
}
