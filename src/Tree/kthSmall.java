package Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。
 */
public class kthSmall {
    private List<Integer> list = new ArrayList<>();
    private int k;
    private int ans = 0;

    public int kthSmallest(TreeNode root, int k){
        this.k = k;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root){
        if (root == null || k <= 0){
            return;
        }
        inorder(root.left);
        k--;
        if (k == 0){
            ans = root.val;
        }
        list.add(root.val);
        inorder(root.right);
    }
}
