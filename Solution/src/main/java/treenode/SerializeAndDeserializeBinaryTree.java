package treenode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2023/4/10 9:57
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                builder.append("null");
            } else {
                builder.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        int index = 0;
        TreeNode root = "null".equals(strs[index]) ? null : new TreeNode(Integer.parseInt(strs[index]));
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if ("null".equals(strs[index + 1])) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(strs[index + 1]));
                queue.add(node.left);
            }
            if ("null".equals(strs[index + 2])) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(strs[index + 2]));
                queue.add(node.right);
            }
            index += 2;
        }
        return root;
    }


    @Test
    public void test() {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        String data = serialize(node1);
        System.out.println(data);
        TreeNode root = deserialize(data);
        TreeNode.inOrder(root);


    }
}
