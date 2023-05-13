package solution10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/14 10:18
 */
public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0);
        return res;
    }

    public void dfs(int[] candidates, int target, int startIndex) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if(candidates[i] <= target){
                path.add(candidates[i]);
                dfs(candidates,target - candidates[i],i);
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test(){
        int[] arr = {2,3,5};
        System.out.println(combinationSum(arr,8));
    }
}
