package treenode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acer
 * @create 2022/10/22 10:43
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        process(root,list,0);
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    public void process(TreeNode node, List<Integer> list, int onePathSum){
        if(node == null){
            return;
        }
        onePathSum += node.val;

        if(node.left == null && node.right == null){
            list.add(onePathSum);
        }
        process(node.left,list,onePathSum * 10);
        process(node.right,list,onePathSum * 10);
        onePathSum -= node.val;
    }
    @Test
    public void test() {
        Codec codec = new Codec();
        String tree = "4,9,5,null,null,1,null,null,0,null,null,";
        TreeNode root = codec.deserialize(tree);
        System.out.println(sumNumbers(root));

    }
}
