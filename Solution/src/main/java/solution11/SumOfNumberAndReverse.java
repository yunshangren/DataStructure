package solution11;

/**
 * @author Acer
 * @create 2023/4/28 10:39
 */
public class SumOfNumberAndReverse {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString()) == num) {
                return true;
            }
        }
        return false;
    }
}
