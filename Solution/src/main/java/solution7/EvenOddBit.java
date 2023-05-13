package solution7;

/**
 * @author Acer
 * @create 2023/3/22 15:43
 */
public class EvenOddBit {
    public int[] evenOddBit(int n) {
        int index = 0;
        int even = 0;
        int odd = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (index % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            index++;
            n >>= 1;
        }
        return new int[]{even, odd};
    }
}
