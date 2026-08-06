package Lookback;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class permute {
    private List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> permute(int[] nums){
        ans = new ArrayList<>();
        path = new ArrayList<>();
        //用来标记哪些索引上的数字已经被用过了
        boolean[] used = new boolean[nums.length];
        dfs(nums, used);

        return ans;
    }

    private void dfs(int[] nums, boolean[] used) {
        if (path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //如果数字已经被使用了,则跳过
            if (used[i]){
                continue;
            }
            //将当前数字标记为已经用过了
            used[i] = true;
            //将当前数字添加到list中
            path.add(nums[i]);

            //递归调用
            dfs(nums, used);

            //回朔
            //删除list中最后一个元素
            path.removeLast();
            //将该数字标记为未被使用
            used[i] = false;
        }
    }
}
