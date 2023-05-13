package treenode;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Acer
 * @create 2023/4/20 13:25
 */
public class MaxPathSum {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        res = Math.max(res, left + right + node.val);
        return Math.max(0, node.val + Math.max(left, right));
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (set.contains(k - root.val)) {
                    return true;
                }
                set.add(root.val);
                root = root.right;
            }
        }
        return false;
    }
}
