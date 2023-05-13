package solution2;

/**
 * @author Acer
 * @create 2023/2/23 16:23
 */
public class CanWinNim {
    public boolean canWinNim(int n) {
        // 如果当前剩余石块不足三个，先手赢
        if (n <= 3) {
            return true;
        }
        //
        for (int i = 1; i < 4; i++) {
            if (!canWinNim(n - i)) {
                return true;
            }
        }
        return false;
    }

    public boolean canWinNim1(int n) {
        if (n <= 3) {
            return true;
        }
        boolean[] memo = new boolean[n + 1];
        for (int i = 0; i < 4; i++) {
            memo[i] = true;
        }
        boolean res = false;
        if (!memo[n]) {
            for (int i = 1; i < 4; i++) {
                if (!canWinNim1(n - i)) {
                    res = true;
                    break;
                }
            }
            memo[n] = res;
        }
        return memo[n];
    }

    public boolean canWinNim2(int n){
        return n % 4 != 0;
    }
}
