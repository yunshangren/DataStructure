package solution3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acer
 * @create 2023/2/28 9:56
 */
public class SubsetsII {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            dfs(nums,0,i);
        }
        return res;
    }

    public void dfs(int[] nums, int startIndex, int targetCnt){
        if(targetCnt == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if(i > startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            dfs(nums,i + 1,targetCnt - 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
