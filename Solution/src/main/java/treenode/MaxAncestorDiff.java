package treenode;

/**
 * @author Acer
 * @create 2023/4/18 19:19
 */
public class MaxAncestorDiff {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int dfs(TreeNode node, int max, int min) {
        if (node == null) {
            return max - min;
        }
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        int res1 = dfs(node.left, max, min);
        int res2 = dfs(node.right, max, min);
        return Math.max(res1, res2);
    }


}
