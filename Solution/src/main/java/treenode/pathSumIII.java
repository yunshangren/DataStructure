package treenode;

import java.util.HashMap;

/**
 * @author Acer
 * @create 2023/4/20 13:21
 */
public class pathSumIII {
    int res = 0;
    HashMap<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        dfs(root, 0, targetSum);
        return res;
    }

    public void dfs(TreeNode node, long sum, int target) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (map.containsKey(sum - target)) {
            res += map.get(sum - target);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(node.left, sum, target);
        dfs(node.right, sum, target);
        map.put(sum, map.get(sum) - 1);
    }
}
