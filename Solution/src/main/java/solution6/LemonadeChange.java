package solution6;

/**
 * @author Acer
 * @create 2023/3/21 14:45
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] counts = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                counts[0]++;
            } else if (bill == 10) {
                if (counts[0] == 0) {
                    return false;
                }
                counts[0]--;
                counts[1]++;
            } else {
                if (counts[0] == 0 || (counts[1] == 0 && counts[0] < 3)) {
                    return false;
                } else if (counts[1] != 0) {
                    counts[0]--;
                    counts[1]--;
                } else {
                    counts[0] -= 3;
                }
            }
        }
        return true;
    }
}
