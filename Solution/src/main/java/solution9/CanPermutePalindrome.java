package solution9;

/**
 * @author Acer
 * @create 2023/4/7 14:38
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        long mask = 0;
        for (char c : s.toCharArray()) {
            mask ^= (1L << (c - ' '));
        }
        return mask == 0 || (mask & (mask - 1)) == 0;
    }
}
