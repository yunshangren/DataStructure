package treenode;

/**
 * @author Acer
 * @create 2023/4/18 20:06
 */
public class SufficientSubset {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode pre = new TreeNode(0);
        pre.left = root;
        dfs(pre, 0, limit);
        return pre.left;
    }

    public boolean dfs(TreeNode node, int sum, int limit) {
        if (node == null) {
            return true;
        }
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum < limit;
        }
        boolean left = dfs(node.left, sum, limit);
        boolean right = dfs(node.right, sum, limit);
        if (left) {
            node.left = null;
        }
        if (right) {
            node.right = null;
        }
        return left && right;
    }

}