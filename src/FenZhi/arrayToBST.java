package FenZhi;


/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 */
public class arrayToBST {
    public TreeNode sortedArrayToBST(int[] nums){
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end){
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = dfs(nums, start, mid - 1);
        node.right = dfs(nums, mid + 1, end);

        return node;
    }
}
