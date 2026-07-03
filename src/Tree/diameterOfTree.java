package Tree;


/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class diameterOfTree {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        //叶子节点的链长为0,返回后需要+1,所以需要返回-1
        if (root == null){
            return -1;
        }
        //左链长度
        int leftLen = dfs(root.left) + 1;
        //右链长度
        int rightLen = dfs(root.right) + 1;

        //求的是路径,也就是边的数量,不是节点的数量
        ans = Math.max(ans , leftLen + rightLen);

        return Math.max(leftLen, rightLen);

    }
}
