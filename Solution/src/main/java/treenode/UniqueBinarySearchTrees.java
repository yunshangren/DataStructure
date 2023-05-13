package treenode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Acer
 * @create 2022/10/18 14:20
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[][] memo = new int[n + 1][n + 1];
        return count(1, n, memo);
    }

    public int count(int left, int right, int[][] memo) {
        if (left > right) {
            return 1;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            int leftCount = count(left, i - 1, memo);
            int rightCount = count(i + 1, right, memo);
            res += leftCount * rightCount;
        }
        memo[left][right] = res;
        return res;
    }

    public List<TreeNode> generateTrees(int n) {

        return generateTree(1, n);
    }

    public List<TreeNode> generateTree(int left, int right) {
        List<TreeNode> res = new LinkedList<>();
        if (left > right) {
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftNodes = generateTree(left, i - 1);
            List<TreeNode> rightNodes = generateTree(i + 1, right);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
