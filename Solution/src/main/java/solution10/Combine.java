package solution10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/14 10:11
 */
public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        dfs(arr,k,0);
        return res;
    }


    public void dfs(int[] arr, int k, int startIndex) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < arr.length; i++) {
            path.add(arr[i]);
            dfs(arr, k - 1, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
