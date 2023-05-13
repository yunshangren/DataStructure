package solution9;

/**
 * @author Acer
 * @create 2023/4/7 16:20
 */
public class IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        s1 += s1;
        return s1.contains(s2);
    }
}
