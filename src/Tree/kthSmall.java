package Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。
 */
public class kthSmall {
    private List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k){
        inorder(root);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
