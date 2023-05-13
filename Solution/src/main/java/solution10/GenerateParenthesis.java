package solution10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/14 12:56
 */
public class GenerateParenthesis {
    List<String> res = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(n, n);
        return res;
    }

    public void dfs(int left, int right) {
        if (left == 0 && right == 0) {
            res.add(builder.toString());
            return;
        }

        if (left > 0) {
            builder.append("(");
            dfs(left - 1, right);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (right > left) {
            builder.append(")");
            dfs(left, right - 1);
            builder.deleteCharAt(builder.length() - 1);
        }

    }

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }
}
