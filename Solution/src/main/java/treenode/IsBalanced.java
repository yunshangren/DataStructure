package treenode;

/**
 * @author Acer
 * @create 2022/10/18 16:28
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        Info info = process(root);
        return info.isBalanced;
    }

    public static class Info{
        int height;
        boolean isBalanced;

        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public Info process(TreeNode node){
        if(node == null){
            return new Info(0,true);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        if(leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) <= 1){
            return new Info(Math.max(leftInfo.height,rightInfo.height) + 1,true);
        }
        return new Info(Math.max(leftInfo.height,rightInfo.height) + 1,false);

    }
}
