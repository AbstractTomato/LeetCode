package Tree;


import java.util.ArrayList;
import java.util.List;

/**
 *给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 */
public class sumNums {
    int ans = 0;
    int cur = 0;
    public int sumNumbers(TreeNode root){
        sum(root);
        return ans;
    }

    private void sum(TreeNode root){
        if (root == null){
            return;
        }

        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null){
            ans += cur;
        }else {
            sum(root.left);
            sum(root.right);
        }
        cur /= 10;
    }
}
