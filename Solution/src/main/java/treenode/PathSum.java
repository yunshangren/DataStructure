package treenode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2022/10/18 16:46
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return process(root, targetSum);

    }

    public boolean process(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        if (target == node.val && node.left == null && node.right == null) {
            return true;
        }
        boolean left = process(node.left, target - node.val);
        boolean right = process(node.right, target - node.val);
        return left || right;
    }


    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        path = new ArrayList<>();
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        target -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.remove(path.size() - 1);

    }
}
