package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/20 19:42
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] arr = new int[s.length()];
        int max = 0;
        arr[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                int len = arr[i - 1];
                int pre = i - len - 1;
                if (pre >= 0 && s.charAt(pre) == '(') {
                    int cur = arr[i - 1] + 2 + (pre - 1 >= 0 ? arr[pre - 1] : 0);
                    arr[i] = cur;
                    max = Math.max(max,cur);
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        String s = ")()())()()(";
        System.out.println(longestValidParentheses(s));
    }
}
