package treenode;

import java.util.Stack;

/**
 * @author Acer
 * @create 2023/3/28 14:17
 */
public class KthLargest {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.right;
            }else{
                root = stack.pop();
                if(--k == 0){
                    return root.val;
                }
                root = root.left;
            }
        }
        return -1;
    }

}
