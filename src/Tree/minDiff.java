package Tree;


import java.util.*;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class minDiff {
    //二叉搜索树中序遍历天然有序
    private Integer prevVal = null;
    private Integer ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        if (prevVal != null){
            ans = Math.min(ans, root.val - prevVal);
        }
        prevVal = root.val;
        inorder(root.right);
    }
}
