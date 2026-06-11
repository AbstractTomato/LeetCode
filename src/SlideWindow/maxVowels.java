package SlideWindow;


import java.util.HashSet;
import java.util.Set;

/**
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 1 <= k <= s.length
 */
public class maxVowels {
    public int maxVowels1(String s, int k){
        if (s == null || s.isEmpty()){
            return 0;
        }

        int curNum = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (int i = 0; i < k; i++){
            if (set.contains(s.charAt(i))){
                curNum++;
            }
        }

        int ans = curNum;
        for (int i = k; i < s.length(); i++){
            if (!set.contains(s.charAt(i)) && set.contains(s.charAt(i - k))){
                curNum--;
            } else if (set.contains(s.charAt(i)) && !set.contains(s.charAt(i - k))) {
                curNum++;
            }
            ans = Math.max(ans, curNum);
        }

        return ans;
    }

    public int maxVowels2(String s, int k){
        int ans = 0;
        int curCount = 0;

        char[] charArray = s.toCharArray();

        for (int right = 0; right < charArray.length; right++) {
            //判断窗口右端是否满足条件
            if (charArray[right] == 'a' || charArray[right] == 'e' || charArray[right] == 'i' || charArray[right] == 'o' || charArray[right] == 'u'){
                curCount++;
            }

            //如果窗口还没形成,则跳过
            int left = right - k + 1;
            if (left < 0){
                continue;
            }

            //更新答案
            ans = Math.max(ans, curCount);
            if (ans == k){
                break;
            }

            //判断左指针
            char out = charArray[left];
            if (out =='a' || out =='e' || out =='i' || out =='o' || out =='u'){
                curCount--;
            }
        }

        return ans;
    }
}
