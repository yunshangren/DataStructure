package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/2 20:20
 */
public class MySqrt {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int res = (int) Math.exp(0.5 * Math.log(x));
        // 2147395600 ---> 46339
        return Math.pow(res + 1,2) <= x ? res + 1 : res;
    }

    @Test
    public void test(){
        System.out.println(mySqrt(2147395600));
    }
}
