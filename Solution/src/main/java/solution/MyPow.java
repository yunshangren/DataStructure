package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/31 16:24
 */
public class MyPow {
    public double myPow(double x, int n) {
        if(x == 1 || n == 0){
            return 1;
        }
        double res = 1;
        long N = n;
        N = Math.abs(N);
        while (N != 0) {
            if ((N & -N) == 1) {
                res *= x;
            }
            x *= x;
            N >>= 1;
        }
        return n > 0 ? res : 1.0 / res;
    }

    @Test
    public void test() {
        System.out.println(myPow(-2,Integer.MIN_VALUE));
    }
}
