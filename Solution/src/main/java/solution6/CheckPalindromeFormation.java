package solution6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/3/18 12:37
 */
public class CheckPalindromeFormation {
    public boolean checkPalindromeFormation(String a, String b) {
        List<Integer> list = new ArrayList<>();
        list.size();

        return check(a, b) || check(b, a);
    }

    public boolean check(String a, String b) {
        int n = a.length();
        int left = 0;
        int right = n - 1;
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) {
            return true;
        }
        return isPalindrome(a, left, right) || isPalindrome(b, left, right);

    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String a = "abdef";
        String b = "fecab";
        System.out.println(checkPalindromeFormation(a, b));
    }

}
