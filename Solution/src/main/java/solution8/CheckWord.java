package solution8;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Acer
 * @create 2023/4/4 19:52
 */
public class CheckWord {
    public boolean isValid(String s) {
        if (s.charAt(0) != 'a' || s.length() < 3) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'c') {
                if (stack.size() < 2 || stack.pop() != 'b') {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }

    public boolean isValid2(String s) {
        int n = s.length();
        if (s.charAt(0) != 'a' || n < 3) {
            return false;
        }
        char[] arr = new char[n];
        int size = 0;
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                if (size < 2 || arr[size - 1] != 'b') {
                    return false;
                } else {
                    size -= 2;
                }
            } else {
                arr[size++] = c;
            }
        }
        return size == 0;
    }

    @Test
    public void test() {
        String s = "abcbcababcabbbcbbc";
        System.out.println(isValid(s));

    }
}
