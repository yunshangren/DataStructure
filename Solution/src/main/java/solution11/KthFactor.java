package solution11;


/**
 * @author Acer
 * @create 2023/5/11 19:26
 */
public class KthFactor {
    public int kthFactor(int n, int k) {
        int top = (int) Math.sqrt(n);
        for (int i = 1; i <= top; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        for (int i = top - (top * top == n ? 1 : 0); i > 0; i--) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return n / i;
                }
            }
        }
        return -1;
    }
}
