package treenode;

/**
 * @author Acer
 * @create 2023/4/10 19:39
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid);
        node.right = dfs(nums, mid + 1, right);
        return node;
    }
}
