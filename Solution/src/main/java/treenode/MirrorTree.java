package treenode;

/**
 * @author Acer
 * @create 2023/3/20 10:37
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftMirror = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = leftMirror;
        return root;
    }
}
