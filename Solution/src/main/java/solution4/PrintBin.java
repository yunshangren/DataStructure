package solution4;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/2 16:35
 */
public class PrintBin {
    public String printBin(double num) {
        // 十进制小数转二进制小数的方法！
        StringBuilder builder = new StringBuilder("0.");
        while (builder.length() <= 32 && num != 0) {
            num *= 2;
            int n = (int) num;
            builder.append(n);
            num -= n;
        }
        return num == 0 ? builder.toString() : "ERROR";
    }

    @Test
    public void test() {
        System.out.println(printBin(0.625));
    }
}
