package treenode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2022/10/22 11:12
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        process(root, list, false);
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    public void process(TreeNode node, List<Integer> list, boolean isLeftLeaf) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && isLeftLeaf) {
            list.add(node.val);
        }
        process(node.left, list, true);
        process(node.right, list, false);

    }

    @Test
    public void test() {
        Codec codec = new Codec();
        String tree = "3,9,null,null,20,15,null,null,7,null,null,";
        TreeNode root = codec.deserialize(tree);
        TreeNode.inOrder(root);
        System.out.println();
        System.out.println(sumOfLeftLeaves(root));
    }
}
