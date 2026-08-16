package DP;


/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class wordDistance {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        //dp[i][j]表示word1的前i个字符转换成word2前j个字符所需的最小步骤
        int[][] dp = new int[n1 + 1][n2 + 1];
        //空字符串不需要转换
        dp[0][0] = 0;

        //初始化
        //当word2为空时,需要把word1的字符全都删除
        for (int i = 1; i <= n1; i++){
            dp[i][0] = dp[i - 1][0] + 1;
        }
        //当word1为空时,需要插入word2的全部单词
        for (int j = 1; j <= n2; j++){
            dp[0][j] = dp[0][j - 1] + 1;
        }

        //状态转移
        for (int i = 1; i <= n1; i++){
            for (int j = 1; j <= n2; j++){
                //如果当前两字符相同,则不需要进行操作,直接继承左上角的结果即可
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    //当前两字符不同,判断插入,删除还是替换所需的操作次数少
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[n1][n2];

    }
}
