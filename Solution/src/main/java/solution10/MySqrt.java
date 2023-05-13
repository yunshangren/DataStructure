package solution10;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/17 10:16
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 2;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (x / mid < mid) {
                right = mid - 1;
            } else if (x / mid > mid) {
                res = mid;
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(mySqrt(2147395599));
    }
}
