package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Acer
 * @create 2022/11/9 20:05
 */
public class MissingRolls {
    public int[] missingRolls(int[] rolls, int mean, int n) {

        int m = rolls.length;
        int sum = (m + n) * mean;
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum > 6 * n || sum < n) {
            return new int[]{};
        }
        int avg = sum / n;
        int[] res = new int[n];
        Arrays.fill(res,avg);
        int diff = sum % n;
        for (int i = 0; i < diff; i++) {
            res[i] += 1;
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = {4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5};
        int[] res = missingRolls(arr,4,40);

    }
}
