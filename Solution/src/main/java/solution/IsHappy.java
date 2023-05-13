package solution;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author Acer
 * @create 2022/11/2 10:04
 */
public class IsHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int temp = 0;
        while (true) {
            while (n > 0) {
                temp += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (temp == 1) {
                return true;
            }
            if (set.contains(temp)) {
                return false;
            }
            set.add(temp);
            n = temp;
            temp = 0;
        }
    }

    @Test
    public void test(){
        for (int i = 1; i < 100; i++) {
            System.out.println( i + "--->" + isHappy(i));
        }
    }
}
