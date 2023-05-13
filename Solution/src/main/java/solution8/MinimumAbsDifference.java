package solution8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2023/3/31 20:32
 */
public class MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int temp = arr[0];
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            diff = Math.min(diff, arr[i] - temp);
            temp = arr[i];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + diff == arr[i + 1]) {
                List<Integer> path = new ArrayList<>();
                path.add(arr[i]);
                path.add(arr[i + 1]);
                res.add(path);
            }
        }
        return res;
    }
}
