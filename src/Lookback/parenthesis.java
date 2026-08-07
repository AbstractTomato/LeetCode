package Lookback;


import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class parenthesis {
    List<String> ans;
    StringBuilder builder;
    public List<String> generateParenthesis(int n){
        ans = new ArrayList<>();
        builder = new StringBuilder();

        dfs(n, 0, 0);

        return ans;
    }

    private void dfs(int n, int left, int right) {
        if (left == n && right == n){
            ans.add(builder.toString());
            return;
        }

        if (left < n){
            builder.append("(");

            dfs(n, left + 1, right);

            builder.deleteCharAt(builder.length() - 1);
        }

        if (right < left){
            builder.append(")");

            dfs(n, left, right + 1);

            builder.deleteCharAt(builder.length() - 1);
        }

    }
}
