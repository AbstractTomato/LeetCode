package Tree;

import java.util.*;


/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        //不改变进入队列的顺序,改变添加list的顺序
        if (root == null){
            return List.of();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        List<List<Integer>> ans = new ArrayList<>();
        int level = 1;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> vals = new ArrayList<>(size);
            while (size-- > 0){
                TreeNode node = queue.poll();
                vals.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            //奇数层不翻转vals链表,偶数层翻转vals链表
            if (level % 2 == 0){
                Collections.reverse(vals);
            }
            level++;
            ans.add(vals);
        }

        return ans;
    }
}
