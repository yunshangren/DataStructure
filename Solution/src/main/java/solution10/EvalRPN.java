package solution10;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Acer
 * @create 2023/4/13 21:08
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!isOperation(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int x = stack.pop();
                int y = stack.pop();
                int temp;
                if ("+".equals(token)) {
                    temp = x + y;
                } else if ("-".equals(token)) {
                    temp = y - x;
                } else if ("*".equals(token)) {
                    temp = x * y;
                } else {
                    temp = y / x;
                }
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    public boolean isOperation(String s) {
        String[] operations = {"+", "-", "*", "/"};
        for (String operation : operations) {
            if (s.equals(operation)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        String[] strs = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(strs));
    }
}
