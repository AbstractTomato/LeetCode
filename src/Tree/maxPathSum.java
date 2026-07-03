package Tree;


/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class maxPathSum {
    private int ans = Integer.MIN_VALUE;
    public int maxSum(TreeNode root){
        dfs(root);
        return ans;
    }

    //遍历每个节点,顺带维护path的最大值
    private int dfs(TreeNode root){
        //如果节点为空,返回0
        if (root == null){
            return 0;
        }

        //左链的和,如果为负数,就直接舍弃这条链
        int leftVal = Math.max(0, dfs(root.left));
        int rightVal = Math.max(0, dfs(root.right));

        ans = Math.max(ans, leftVal + rightVal + root.val);

        return Math.max(leftVal, rightVal) + root.val;
    }
}
