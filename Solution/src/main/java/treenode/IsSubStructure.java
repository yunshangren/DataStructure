package treenode;

/**
 * @author Acer
 * @create 2023/3/20 9:49
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A == B) {
            return true;
        }
        return process(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean process(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return process(A.left, B.left) && process(A.right, B.right);

    }


}
