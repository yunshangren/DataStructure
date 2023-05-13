package treenode;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/26 20:19
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return process(preorder,inorder,0,preorder.length,0,inorder.length);
    }

    public TreeNode process(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (iStart >= iEnd) {
            return null;
        }
        int rootValue = preorder[pStart];
        int rootIndex = -1;
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == rootValue){
                rootIndex = i;
                break;
            }
        }
        int leftSize = rootIndex - iStart;
        TreeNode node = new TreeNode(rootValue);
        node.left = process(preorder, inorder, pStart + 1, pStart + leftSize + 1, iStart, rootIndex);
        node.right = process(preorder,inorder,pStart + leftSize + 1,pEnd,rootIndex + 1,iEnd);
        return node;
    }

    @Test
    public void test(){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        TreeNode.preOrder(root);
        System.out.println("==============");
        TreeNode.inOrder(root);
    }
}
