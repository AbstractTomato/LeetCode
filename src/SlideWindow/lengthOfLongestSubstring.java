package SlideWindow;


import javax.naming.AuthenticationNotSupportedException;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 */
public class lengthOfLongestSubstring {

    public int lengthOfLongestSubstring1(String s){
        if (s == null || s.isEmpty()){
            return 0;
        }

        //key存字符, value表示它的索引下标
        Map<Character, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;

        int len = s.length();

        //左右指针
        int left = 0, right = 0;

        while (right < len){
            //当前字符c
            char c = s.charAt(right);
            if (map.containsKey(c)){
                //如果字符已存在,并且上次出现的位置还是在窗口内,则更新left
                left = Math.max(map.get(c) + 1, left);
            }

            res = Math.max(res, right - left + 1);
            map.put(c, right);
            right++;
        }

        return res;
    }
}
