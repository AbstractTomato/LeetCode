package DP;


/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 */
public class interLeave {
    public boolean isInterleave(String s1, String s2, String s3){
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        //如果s1的长度 + s2的长度 != s3的长度,直接返回false
        if(n1 + n2 != n3){
            return false;
        }

        //dp[i][j]表示能不能s3前i+j个字符能不能被s1的前i个字符 + s2的前j个字符表示
        boolean[][] dp = new boolean[n1 + 1][n2 + 2];
        dp[0][0] = true;

        //初始化第一列,看看s3前n1个字符能不能被s1的前n1个字符表示
        for (int i = 1; i <= n1; i++){
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        //初始化第一行,判断s3前n2个字符能不能被s2的前n2个字符表示
        for (int j = 1; j <= n2; j++){
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        //开始判断后续
        for (int i = 1; i <= n1; i++){
            for (int j = 1; j <= n2; j++){
                //最后一个字符可以被s1或者s2表示
                //尝试让s1的第i个字符作为结尾
                boolean fromS1 = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                //尝试让s2的第j个字符作为结尾
                boolean fromS2 = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);

                dp[i][j] = fromS1 || fromS2;
            }
        }

        return dp[n1][n2];
    }
}
