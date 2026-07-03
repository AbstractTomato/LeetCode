package Tree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 */
public class hasPath {
    int sum = 0;
    Set<Integer> set = new HashSet<>();
    public boolean hasPathSum1(TreeNode root, int targetSum){
        if (root == null){
            return false;
        }
        setSum(root);
        return set.contains(targetSum);
    }

    private void setSum(TreeNode root){
        if (root == null){
            //直接返回
            return;
        }
        sum += root.val;
        if (root.left == null && root.right == null){
            set.add(sum);
        }else {
            setSum(root.left);
            setSum(root.right);
        }
        sum -= root.val;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum){
        if (root == null){
            return false;
        }
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int curSum, int targetSum){
        if (root == null){
            return false;
        }
        curSum += root.val;
        if (root.left == null && root.right == null){
            return curSum == targetSum;
        }else {
            return dfs(root.left, curSum, targetSum) || dfs(root.right, curSum, targetSum);
        }
    }
}
