package DP;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class breakWord {
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        int n = set.size();

        //dp[i]表示从s.substring(0, i)可以被wordDict组成
        boolean[] dp = new boolean[n + 1];
        //dp[0]表示空字符串, 空字符串肯定可以被表示的
        dp[0] = true;

        //i表示验证的字符串的总长度
        for (int i = 1; i <= n; i++){
            //此时需要从头开始判断这个子串能不能被字典表示
            for (int j = 0; j < i; j++){
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
