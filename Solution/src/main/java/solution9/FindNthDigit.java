package solution9;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/12 14:25
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int bit = 1;
        long num = 9;
        while (n > num) {
            n -= num;
            num = (long) ((9 * Math.pow(10, bit)) * ++bit);
        }
        int i = (n - 1) / bit;
        int mod = n - i * bit;
        n = (int) (Math.pow(10, bit - 1) + i);
        String s = String.valueOf(n);
        return s.charAt(mod - 1) - '0';
    }

    @Test
    public void test() {
        System.out.println(findNthDigit(1000000000));
    }
}
