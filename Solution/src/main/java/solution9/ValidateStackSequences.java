package solution9;

import java.util.Stack;

/**
 * @author Acer
 * @create 2023/4/7 10:19
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int size = 0;
        int index = 0;
        for (int i : pushed) {
            pushed[size++] = i;
            while (size > 0 && pushed[size - 1] == popped[index]) {
                size--;
                index++;
            }
        }
        return size == 0;
    }

}
