package treenode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Acer
 * @create 2022/10/21 20:02
 */
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                builder.append("null");
            }else{
                builder.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            builder.append(",");
        }
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        if ("null".equals(s[0])) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s[0])), p = root;
        int i = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(p);
        while (i < s.length) {
            p = queue.removeFirst();
            if (!"null".equals(s[i])) {
                p.left = new TreeNode(Integer.parseInt(s[i]));
                queue.addLast(p.left);
            }
            if (i + 1 < s.length && !"null".equals(s[i + 1])) {
                p.right = new TreeNode(Integer.parseInt(s[i + 1]));
                queue.addLast(p.right);
            }
            i += 2;
        }
        return root;
    }



    @Test
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        Codec codec = new Codec();
        String tree = codec.serialize(node1);
        System.out.println(tree);
    }

}
