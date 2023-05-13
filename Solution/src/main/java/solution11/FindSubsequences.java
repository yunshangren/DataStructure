package solution11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Acer
 * @create 2023/4/28 14:06
 */
public class FindSubsequences {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int index) {
        boolean[] visited = new boolean[201];
        for (int i = index; i < nums.length; i++) {
            if ((!path.isEmpty() && nums[i] < path.peekLast()) || visited[nums[i] + 100]) {
                continue;
            }
            path.add(nums[i]);
            visited[nums[i] + 100] = true;
            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }
            dfs(nums, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1};
        System.out.println(findSubsequences(arr));
    }
}
