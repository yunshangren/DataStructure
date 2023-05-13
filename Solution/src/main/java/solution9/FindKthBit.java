package solution9;

import org.junit.Test;

/**
 * @author Acer
 * @create 2023/4/10 15:04
 */
public class FindKthBit {
    int[] len;

    public char findKthBit(int n, int k) {
        len = new int[n + 1];
        len[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            len[i] = (len[i - 1] << 1) + 1;
        }
        return dfs(n, k);
    }

    public char dfs(int n, int k) {
        int mid = (len[n] + 1) >> 1;
        if (k == mid) {
            return n == 1 ? '0' : '1';
        } else if (k > mid) {
            return dfs(n, 2 * mid - k) == '0' ? '1' : '0';
        } else {
            return dfs(n - 1, k);
        }

    }

    @Test
    public void test() {
        System.out.println(findKthBit(4, 11));
    }
}
