package solution10;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2023/4/12 20:42
 */
public class CountBits {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            res[i] = count(i);
        }
        return res;
    }

    public int count(int i) {
        int res = 0;
        while (i > 0) {
            res++;
            i &= (i - 1);
        }
        return res;
    }

    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits2(5)));
    }
}
