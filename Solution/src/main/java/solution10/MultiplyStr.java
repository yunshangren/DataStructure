package solution10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/13 15:02
 */
public class MultiplyStr {
    public String multiply1(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        List<String> list = new ArrayList<>();
        for (int i = m - 1; i >= 0; i--) {
            int x = chars1[i] - '0';
            StringBuilder builder = new StringBuilder();
            int carry = 0;
            int pro = 1;
            for (int j = n - 1; j >= 0; j--) {
                int y = chars2[j] - '0';
                pro = x * y + carry;
                carry = pro / 10;
                pro = pro % 10;
                builder.append(pro);
            }
            if (carry > 0) {
                builder.append(carry);
            }
            builder.reverse();
            builder.append("0".repeat(m - i - 1));
            list.add(builder.toString());
        }
        String res = "0";
        for (String s : list) {
            res = new AddStrings().addStrings(res, s);
        }
        return res;
    }


    @Test
    public void test() {
        String s1 = "1256564";
        String s2 = "45667756788666";
        System.out.println(multiply1(s1, s2));
    }
}
