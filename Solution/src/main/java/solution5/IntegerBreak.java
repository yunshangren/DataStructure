package solution5;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/3/11 14:28
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int i = n / 3;
        int mod = n % 3;
        if (mod == 0) {
            return (int) Math.pow(3, i);
        } else if (mod == 1) {
            return (int) (Math.pow(3, i - 1) * 4);
        } else {
            return (int) (Math.pow(3, i) * 2);
        }
    }

    @Test
    public void test(){
        System.out.println(integerBreak(4));
        
    }
}
