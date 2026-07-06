package Tree;


import org.ietf.jgss.Oid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，
 * 想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class rightView {
    //BFS
    public List<Integer> rightSideView1(TreeNode root){
        if (root == null){
            return List.of();
        }

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                if (size == 0){
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

    //DFS
    public List<Integer> rightSideView2(TreeNode root){
        if (root == null){
            return List.of();
        }
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);

        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans){
        if (root == null){
            return;
        }
        //列表首次到达深度大小
        if (depth == ans.size()){
            ans.add(root.val);
        }
        //先递归右树
        dfs(root.right, depth + 1, ans);
        dfs(root.left, depth + 1, ans);
    }
}
