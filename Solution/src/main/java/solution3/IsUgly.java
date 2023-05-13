package solution3;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/2/24 14:11
 */
public class IsUgly {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;
        return n == 1;

    }



    @Test
    public void test() {
        System.out.println();
    }
}
