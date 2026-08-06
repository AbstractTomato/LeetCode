package Lookback;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class combinationSum {
    private List<List<Integer>> ans;
    private List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        //排序,为后续剪枝做铺垫
        Arrays.sort(candidates);
        dfs(candidates, target, 0);

        return ans;
    }

    private void dfs(int[] candidates, int target, int start) {
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0){
                return;
            }

            path.add(candidates[i]);

            //允许重复搜索,所以下一个start依旧可以是i,而不是i + 1
            dfs(candidates, target - candidates[i], i);

            path.removeLast();
        }
    }
}
