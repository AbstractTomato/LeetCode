package Lookback;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 */
public class queen2 {
    private int ans;
    public int totalNQueens(int n){
        ans = 0;

        //表示这一列是否放了皇后
        boolean[] col = new boolean[n];

        //判断对角线是否有皇后, 为防止索引为负数,需要加一个常数 n - 1
        //主对角线
        boolean[] diag1 = new boolean[2 * n - 1];
        //副对角线
        boolean[] diag2 = new boolean[2 * n - 1];

        //从第 0 行开始
        dfs(0, n, col, diag1, diag2);

        return ans;
    }

    private void dfs(int row, int n, boolean[] col, boolean[] diag1, boolean[] diag2) {
        if (row == n){
            ans++;
            return;
        }

        //对每一行的列循环
        for (int i = 0; i < n; i++) {
            //计算当前格子对应的主对角线和副对角线的索引
            //主对角线上 行 - 列 固定,但是索引不能为负数
            int d1 = row - i + n - 1;
            //副对角线上 行 + 列 固定的
            int d2 = row + i;

            if (col[i] || diag1[d1] || diag2[d2]){
                continue;
            }

            col[i] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            dfs(row + 1, n, col, diag1, diag2);

            col[i] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
