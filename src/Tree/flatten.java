package Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class flatten {
    public void flattenTreeByPreorder(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode cur = list.get(i);
            TreeNode nxt = list.get(i + 1);
            cur.left = null;
            cur.right = nxt;
        }
    }

    public void preorder(TreeNode root, List<TreeNode> list){
        if (root == null){
            return;
        }
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
