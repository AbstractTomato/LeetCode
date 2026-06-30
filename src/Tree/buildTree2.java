package Tree;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class buildTree2 {
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder){
        int len = postorder.length;
        for (int i = 0; i < len; i++){
            indexMap.put(inorder[i], i);
        }

        return build(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    private TreeNode build(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR){
        if (postL > postR){
            return null;
        }

        //获取根节点
        int rootVal = postorder[postR];
        TreeNode root = new TreeNode(rootVal);
        //拿到根节点在中序数组中的索引
        int rootIndex = indexMap.get(rootVal);
        //计算左子树的大小
        int leftSize = rootIndex - inL;

        //递归计算左子树
        root.left = build(inorder, inL, rootIndex - 1,
                postorder, postL, postL + leftSize - 1);

        //递归计算右子树
        root.right = build(inorder, rootIndex + 1, inR,
                postorder, postL + leftSize, postR - 1);

        return root;
    }
}
