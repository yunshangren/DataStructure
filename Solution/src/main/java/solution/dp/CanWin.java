package solution.dp;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author Acer
 * @create 2022/11/7 10:38
 */
public class CanWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        HashSet<Integer> set = new HashSet<>();
        return f(maxChoosableInteger, set, desiredTotal);
    }

    public boolean f(int maxNum, HashSet<Integer> set, int target) {
        if (maxNum >= target || target <= 0) {
            return true;
        }
        if ((1 + maxNum) * maxNum / 2 < target) {
            return false;
        }
        for (int i = 1; i <= maxNum; i++) {
            if (!set.contains(i)) {
                set.add(i);
                if (!f(maxNum, set, target - i)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Test
    public void test() {
        for (int i = 0; i < 55; i++) {
            System.out.println("i -- >" + i + " " + canIWin(15, i));
        }

    }
}
