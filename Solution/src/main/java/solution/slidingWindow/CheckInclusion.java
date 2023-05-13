package solution.slidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author Acer
 * @create 2022/10/18 20:33
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int valid = 0;
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if(Objects.equals(window.get(d), need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d) - 1);
                }
            }
        }
        return false;

    }

    @Test
    public void test() {
        String s1 = "trinitrophenylmethylnitramine";
        String s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";
        System.out.println(checkInclusion(s1, s2));
    }
}
