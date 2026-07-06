package Tree;


import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class levelOrder {
    //用两个list集合来做
    public List<List<Integer>> levelOrder1(TreeNode root){
        if (root == null){
            return List.of();
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> curLevel = List.of(root);

        while (!curLevel.isEmpty()){
            //存储这一层的值
            List<Integer> vals = new ArrayList<>(curLevel.size());
            //存放节点
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : curLevel) {
                vals.add(node.val);
                if (node.left != null){
                    nextLevel.add(node.left);
                }
                if (node.right != null){
                    nextLevel.add(node.right);
                }
            }
            curLevel = nextLevel;
            ans.add(vals);
        }
        return ans;
    }

    //用队列来做
    public List<List<Integer>> levelOrder2(TreeNode root){
        if (root == null){
            return List.of();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> vals = new ArrayList<>(size);
            while (size-- > 0){
                TreeNode poll = queue.poll();
                vals.add(poll.val);
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
            }
            ans.add(vals);
        }
        return ans;
    }
}
