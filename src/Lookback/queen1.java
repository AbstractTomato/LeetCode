package Lookback;


import java.util.ArrayList;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class queen1 {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> solveNQueens(int n){
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        dfs(col, diag1, diag2, n, 0);

        return ans;
    }

    private void dfs(boolean[] col, boolean[] diag1, boolean[] diag2, int n, int row) {
        if (path.size() == n){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++){
            int d1 = row - i + n - 1;
            int d2 = row + i;

            if (col[i] || diag1[d1] || diag2[d2]){
                continue;
            }

            //标记
            col[i] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            char[] tmp = new char[n];
            for (int j = 0; j < n; j++) {
                if (j == i){
                    tmp[j] = 'Q';
                }else {
                    tmp[j] = '.';
                }
            }

            path.add(new String(tmp));

            dfs(col, diag1, diag2, n, row + 1);

            col[i] = false;
            diag1[d1] = false;
            diag2[d2] = false;

            path.removeLast();

        }
    }
}
