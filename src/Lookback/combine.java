package Lookback;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class combine {
    private List<List<Integer>> ans;
    private List<Integer> path;
    public List<List<Integer>> combine(int n, int k){
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int start = 1;
        dfs(n, k, start);

        return ans;
    }

    private void dfs(int n, int k, int start) {
        if (path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < n - (k - path.size()) + 1; i++){
            path.add(i);

            dfs(n, k, i + 1);

            path.removeLast();
        }
    }


}
