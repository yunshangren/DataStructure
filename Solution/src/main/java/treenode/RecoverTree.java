package treenode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Acer
 * @create 2022/10/24 11:16
 */
public class RecoverTree {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public void swap(TreeNode p, TreeNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }

    @Test
    public void test() {
        Codec codec = new Codec();
        String tree = "3,1,null,null,4,2,null,null,null,";
        TreeNode root = codec.deserialize(tree);

    }
}
