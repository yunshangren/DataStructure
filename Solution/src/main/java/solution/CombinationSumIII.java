package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        backtrack(arr,res,list,n,k,0);
        return res;
    }

    public void backtrack(int[] arr, List<List<Integer>> res, List<Integer> list, int target, int n, int startIndex) {
        if (n == 0 && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < ((1 + n) * n) >> 1 || target > n * (19 - n) >> 1) {
            return;
        }
        for (int i = startIndex; i < arr.length; i++) {
            if (target > 0) {
                target -= arr[i];
                list.add(arr[i]);
                backtrack(arr, res, list, target, n - 1, i + 1);
                target += arr[i];
                list.remove(list.size() - 1);
            }
        }
    }
    @Test
    public void test(){

        List<List<Integer>> lists = combinationSum3(3,9);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
