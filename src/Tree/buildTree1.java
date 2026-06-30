package Tree;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class buildTree1 {

    //构建hashmap
    //key存数组元素,value存数组下标
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder){
        //拿到数组长度
        int len = preorder.length;
        for (int i = 0; i < len; i++){
            indexMap.put(inorder[i], i);
        }

        return build(preorder, 0, len - 1, inorder, 0, len - 1);
    }

    private TreeNode build(int[] preorder, int preL, int preR,
                           int[] inorder, int inL, int inR){
        //根节点的值
        int rootVal = preorder[preL];
        //新建一个根节点
        TreeNode root = new TreeNode(rootVal);
        //拿到根节点在中序数组中的下标
        int rootIndex = indexMap.get(rootVal);
        //计算根节点的左子树长度
        int leftSize = rootIndex - inL;

        //递归构建左子树
        root.left = build(preorder, preL + 1, preL + leftSize,
                inorder, inL, rootIndex - 1);

        //递归构建右子树
        root.right = build(preorder, preL + leftSize + 1, preR,
                inorder, rootIndex + 1, inR);

        return root;
    }
}
