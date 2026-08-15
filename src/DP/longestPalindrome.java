package DP;


/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 */
public class longestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()){
            return null;
        }

        if (s.length() < 2){
            return s;
        }

        int length = s.length();
        //dp[i][j]表示索引为(i,j)子串是不是回文串
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;

        //子串长度
        for (int len = 2; len <= length; len++){
            //左端点, 循环的条件是为了防止右端点越界
            for (int i = 0; i <= length - len; i++){
                //右端点
                int j = i + len - 1;

                //如果左右两字符相等
                if (s.charAt(i) == s.charAt(j)){
                    //如果长度小于等于2,肯定是回文串, 如果
                    if (len <= 2 || dp[i + 1][j - 1]){
                        dp[i][j] = true;

                        if (len > maxLen){
                            maxLen = len;
                            start = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

}
