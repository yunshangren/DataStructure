package solution9;

/**
 * @author Acer
 * @create 2023/4/12 15:09
 */
public class CuttingRope {
    public int cuttingRope(int n) {
        if (n <= 4) {
            return n == 4 ? n : n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = (3 * res) % 1000000007;
            n -= 3;
        }
        return (int) ((res * n) % 1000000007);
    }
}
