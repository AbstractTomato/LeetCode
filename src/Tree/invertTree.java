package Tree;


/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class invertTree {
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return root;
        }

        //翻转左子树
        TreeNode left = invertTree(root.left);
        //翻转右子树
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;

    }
}
