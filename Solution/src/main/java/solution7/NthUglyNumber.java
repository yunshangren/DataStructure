package solution7;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Acer
 * @create 2023/3/27 15:39
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int product2, product3, product5;
        product2 = product3 = product5 = 1;
        int p2, p3, p5;
        p2 = p3 = p5 = 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            int min = Math.min(product2, Math.min(product3, product5));
            dp[i] = min;
            if (min == product2) {
                product2 = 2 * dp[p2++];
            }
            if (min == product3) {
                product3 = 3 * dp[p3++];
            }
            if (min == product5) {
                product5 = 5 * dp[p5++];
            }
        }
        return dp[n];
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        int res = 1;
        // int[] arr; arr[0] = primes[index], arr[1] = dp[index], arr[2] = index;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0] * o[1]));
        return 0;
    }

    @Test
    public void test() {
        System.out.println(nthUglyNumber(1));
    }
}

