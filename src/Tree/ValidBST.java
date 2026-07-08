package Tree;


/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 严格小于 当前节点的数。
 * 节点的右子树只包含 严格大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidBST {
    private Integer preVal = null;
    private boolean ans = true;
    public boolean isValidBST(TreeNode root){
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        if (preVal != null){
            if (preVal >= root.val){
                ans = false;
                return;
            }
        }
        preVal = root.val;
        inorder(root.right);
    }

}
