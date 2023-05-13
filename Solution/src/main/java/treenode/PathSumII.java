package treenode;

import org.junit.Test;

import java.util.*;

/**
 * @author Acer
 * @create 2022/10/21 19:25
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        dfs(root, res, path, targetSum);
        return res;
    }

    public void dfs(TreeNode node, List<List<Integer>> res, List<Integer> path, int targetSum) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        if (node.left == null && node.right == null && targetSum == node.val) {
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, res, path, targetSum - node.val);
        dfs(node.right, res, path, targetSum - node.val);
        path.remove(path.size() - 1);
    }

    @Test
    public void test() {
        Codec codec = new Codec();
        String tree = "5,4,11,7,null,null,2,null,null,null,8,13,null,null,4,5,null,null,1,null,null,";
        TreeNode root = codec.deserialize(tree);
        List<List<Integer>> lists = pathSum(root, 22);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }

    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;
        Codec codec = new Codec();
        System.out.println(codec.serialize(node1));
    }
}
