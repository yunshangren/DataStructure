package treenode;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/8 16:41
 */
public class ConvertBST {

    public TreeNode convertBST(TreeNode root) {
        rInorder(root);
        return root;
    }

    int sum = 0;

    public void rInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        rInorder(root.right);
        sum += root.val;
        root.val = sum;
        rInorder(root.left);
    }

    @Test
    public void test() {
        Codec codec = new Codec();

    }
}
