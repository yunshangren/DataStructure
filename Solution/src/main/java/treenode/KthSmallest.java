package treenode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2022/10/22 10:54
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list.get(k - 1);
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    @Test
    public void test() {
        Codec codec = new Codec();
        String tree = "3,1,null,null,2,null,null,4,null,null,";
        TreeNode root = codec.deserialize(tree);
        TreeNode.inOrder(root);
    }
}
