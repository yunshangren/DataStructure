package solution10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/14 10:42
 */
public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int cnt) {
        if (cnt == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                dfs(nums, cnt + 1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
