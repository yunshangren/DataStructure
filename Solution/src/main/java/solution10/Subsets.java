package solution10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/14 9:57
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        res.add(path);
        for (int i = 1; i <= nums.length; i++) {
            dfs(nums, i, 0);
        }
        return res;
    }

    public void dfs(int[] nums, int cnt, int index) {
        if (cnt == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, cnt - 1, i + 1);
            path.remove(path.size() - 1);
        }

    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

}
