package DP;


/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class stair {
    public int climbStairs1(int n){
        return dfs1(n);
    }

    private int dfs1(int n){
        if (n <= 1){
            return 1;
        }

        return dfs1(n -1) + dfs1(n - 2);
    }


    public int climbStairs2(int n){
        int[] memo = new int[n + 1];

        return dfs2(n, memo);
    }

    private int dfs2(int n, int[] memo){
        if (n <= 1) return 1;

        if (memo[n] != 0){
            return memo[n];
        }

        return memo[n] = dfs2(n - 1, memo) + dfs2(n - 2, memo);
    }

    public int climbStairs3(int n){
        int[] f = new int[n + 1];

        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i <= n; i++){
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public int climbStairs4(int n){
        int f0 = 1;
        int f1 = 1;

        for (int i = 2; i <= n; i++){
            int newF = f0 + f1;
            f0 = f1;
            f1 = newF;
        }

        return f1;
    }
}
