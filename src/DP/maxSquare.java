package DP;


/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class maxSquare {
    public static int maximalSquare(char[][] matrix){
        if (matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = 1;
                    ans = 1;
                }
            }
        }


        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (dp[i][j] == 0){
                    continue;
                }else {
                    if (dp[i - 1][j - 1] != 0 && dp[i - 1][j] != 0 && dp[i][j - 1] != 0){
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }

        return ans * ans;
    }
}
