package solution9;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Acer
 * @create 2023/4/6 15:53
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            int index = c - 'a';
            count[index]--;
            if (visited[index]) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek()) {
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[index] = true;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public String removeDuplicateLetters2(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        char[] stack = new char[chars.length];
        int size = 0;
        for (char c : chars) {
            count[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (size != 0 && c < stack[size - 1]) {
                if (count[stack[size - 1] - 'a'] == 0) {
                    break;
                }
                visited[stack[size - 1] - 'a'] = false;
                size--;
            }
            stack[size++] = c;
            visited[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : stack) {
            if (c >= 'a') {
                builder.append(c);
            } else {
                break;
            }
        }
        return builder.toString();
    }

    @Test
    public void test() {
        String s1 = "cbacdcbc";
        String s2 = "azdbcabc";
        System.out.println(removeDuplicateLetters(s1));
        System.out.println(removeDuplicateLetters2(s1));


    }
}
