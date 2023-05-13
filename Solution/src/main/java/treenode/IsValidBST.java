package treenode;

/**
 * @author Acer
 * @create 2022/10/24 9:49
 */
public class IsValidBST {
    static class Info {
        int min;
        int max;
        boolean isValidBST;

        public Info(int min, int max, boolean isValidBST) {
            this.min = min;
            this.max = max;
            this.isValidBST = isValidBST;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root) == null || dfs(root).isValidBST;
    }

    public Info dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        Info leftInfo = dfs(node.left);
        Info rightInfo = dfs(node.right);

        int maxValue = node.val;
        int minValue = node.val;
        if (leftInfo != null) {
            maxValue = Math.max(leftInfo.max, maxValue);
            minValue = Math.min(leftInfo.min, minValue);
        }
        if (rightInfo != null) {
            maxValue = Math.max(rightInfo.max, maxValue);
            minValue = Math.min(rightInfo.min, minValue);
        }

        boolean isValidBST = leftInfo == null || (leftInfo.isValidBST && leftInfo.max < node.val);
        // 如果左子树不为空，但是左子树不是二叉搜索树，或者左子树的最大值不小于根节点的值
        if (rightInfo != null && (!rightInfo.isValidBST || rightInfo.min <= node.val)) {
            isValidBST = false;
        }
        return new Info(minValue, maxValue, isValidBST);
    }


}
