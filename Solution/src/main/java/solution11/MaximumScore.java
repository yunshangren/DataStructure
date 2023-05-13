package solution11;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/5/5 13:24
 */
public class MaximumScore {


    public int maximumScore(int a, int b, int c) {
        int zeros = 0;
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a + b + c - min - max;
        if (min == 0) {
            zeros++;
        }
        if (mid == 0) {
            zeros++;
        }
        if (max == 0) {
            zeros++;
        }
        if (zeros > 1) {
            return 0;
        }
        int res = 0;
        if (min == mid) {
            res += maximumScore(min, mid - 1, max - 1) + 1;
        } else {
            res += maximumScore(min, min, max - mid + min) + mid - min;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(maximumScore(8, 22, 16));
    }
}
