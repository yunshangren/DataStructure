package solution7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2023/3/23 18:49
 */
public class CheckArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        int m = l.length;
        for (int i = 0; i < m; i++) {
            if (r[i] - l[i] < 2) {
                res.add(Boolean.TRUE);
            } else {
                int[] arr = new int[r[i] - l[i] + 1];
                System.arraycopy(nums, l[i], arr, 0, arr.length);
                if (check(arr)) {
                    res.add(Boolean.TRUE);
                } else {
                    res.add(Boolean.FALSE);
                }
            }
        }
        return res;
    }

    public boolean check(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
