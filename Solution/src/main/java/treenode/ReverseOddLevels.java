package treenode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2023/3/31 20:50
 */
public class ReverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        int level = 1;
        queue1.add(root.left);
        queue2.add(root.right);
        while (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if ((level & 1) == 1) {
                    int temp = node1.val;
                    node1.val = node2.val;
                    node2.val = temp;
                }
                if (node1.left != null) {
                    queue1.add(node1.left);
                    queue1.add(node1.right);
                }
                if (node2.right != null) {
                    queue2.add(node2.right);
                    queue2.add(node2.left);
                }
            }
            level++;
        }
        return root;
    }


}
