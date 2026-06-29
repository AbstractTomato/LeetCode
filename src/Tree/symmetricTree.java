package Tree;


/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class symmetricTree {
    public boolean isSymmetric(TreeNode root){
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        } else if (left == null || right == null) {
            return false;
        }else {
            return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
        }
    }

}
