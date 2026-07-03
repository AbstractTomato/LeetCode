package Tree;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    List<Integer> list;
    int index;
    public BSTIterator(TreeNode root) {
        index = 0;
        list = new ArrayList<>();
        inorderTraversal(root, list);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
