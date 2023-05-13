package solution11;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/20 16:39
 */
public class RemoveDuplicates {

    static class Element {
        Character c;
        int count;

        public Element(Character c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Element[] stack = new Element[s.length()];
        int size = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (size == 0 || c != stack[size - 1].c) {
                stack[size++] = new Element(c, 1);
            } else if (c == stack[size - 1].c) {
                stack[size++] = new Element(c, stack[size - 2].count + 1);
                if (stack[size - 1].count == k) {
                    size -= k;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(stack[i].c);
        }
        return builder.toString();
    }

    @Test
    public void test() {
        String s = "deeedbbcccbdaa";
        System.out.println(removeDuplicates(s, 3));
    }
}
