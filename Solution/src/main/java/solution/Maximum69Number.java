package solution;

import java.util.Stack;

/**
 * @author Acer
 * @create 2022/11/2 14:25
 */
public class Maximum69Number {
    public int maximum69Number (int num) {
        Stack<Integer> stack = new Stack<>();
        while (num > 0){
            int n = num % 10;
            num /= 10;
            stack.push(n);
        }
        int res = 0;
        boolean turn = false;
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            if(!turn && pop == 6){
                pop = 9;
                turn = true;
            }
            res *= 10;
            res += pop;
        }
        return res;
    }
}
