package solution;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author Acer
 * @create 2022/10/28 15:21
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : chars) {
            while (!deque.isEmpty() && map.get(deque.peekLast()) > 0 && c < deque.peekLast() && !deque.contains(c)) {
                deque.pollLast();
            }
            if(!deque.contains(c)){
                deque.addLast(c);
            }
            map.put(c,map.get(c) - 1);

        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollFirst());
        }
        return builder.toString();
    }

    @Test
    public void test() {
        String s = "cdadabcc";
        System.out.println(removeDuplicateLetters(s));
    }
}
