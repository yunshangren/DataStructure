package solution9;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/7 14:49
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        }
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        String longer = len1 >= len2 ? first : second;
        String shorter = len1 < len2 ? first : second;

        int p1 = 0;
        int p2 = Math.max(len1, len2) - 1;
        int p3 = Math.min(len1, len2) - 1;

        while (p1 < shorter.length() && longer.charAt(p1) == shorter.charAt(p1)) {
            p1++;
        }
        while (p3 >= 0 && longer.charAt(p2) == shorter.charAt(p3)) {
            p2--;
            p3--;
        }
        return p1 == p2;

    }

    @Test
    public void test() {
        String s1 = "";
        String s2 = "a";
        System.out.println(oneEditAway(s1, s2));
    }
}
