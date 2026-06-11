package SlideWindow;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 */
public class findSubString {
    public List<Integer> findSubstring(String s, String[] words){
        int wordLen = words[0].length();
        int windowLen = wordLen * words.length;

        //目标:窗口内的单词出现次数必须与targetCnt完全一致
        Map<String, Integer> targetCnt = new HashMap<>();
        for (String word : words) {
            targetCnt.merge(word, 1, Integer::sum);
        }

        List<Integer> ans = new ArrayList<>();

        //总共要进行wordLen次判断,从不同的起点开始滑动
        for (int start = 0; start < wordLen; start++){
            Map<String, Integer> cnt = new HashMap<>();

            //统计过多的单词数,包括words中不存在的单词
            int overload = 0;

            //窗口的右开端点, 开端点!!!
            for (int right = start + wordLen; right <= s.length(); right+=wordLen){
                //枚举进入窗口的inWord
                String inWord = s.substring(right - wordLen, right);
                //如果在自增之前,inWord在cnt出现的次数就已经和在targetCnt中出现的次数相同,
                //则表明这个inWord是过多的,此时overload++;
                if (cnt.getOrDefault(inWord, 0)
                        .equals(targetCnt.getOrDefault(inWord, 0))){
                    overload++;
                }
                cnt.merge(inWord, 1, Integer::sum);

                //窗口的左端点
                int left = right - windowLen;
                if (left < 0){
                    continue;
                }

                //更新答案
                if (overload == 0){
                    ans.add(left);
                }

                //出
                String outWord = s.substring(left, left + wordLen);
                cnt.merge(outWord, -1, Integer::sum);
                if (cnt.get(outWord)
                        .equals(targetCnt.getOrDefault(outWord, 0))){
                    overload--;
                }
            }
        }

        return ans;
    }

    public List<Integer> method(String s, String[] words){
        List<Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int windowLen = words.length * wordLen;

        if (s == null || s.isEmpty() || s.length() < windowLen){
            return ans;
        }

        Map<String, Integer> targetCnt = new HashMap<>();
        for (String word : words) {
            targetCnt.merge(word, 1, Integer::sum);
        }

        for (int start = 0; start < wordLen; start++){
            Map<String, Integer> cnt = new HashMap<>();
            int overload = 0;
            for (int right = start + wordLen; right <= s.length(); right += wordLen){
                String inWord = s.substring(right - wordLen, right);

                boolean flag1 = cnt.getOrDefault(inWord, 0).equals(targetCnt.getOrDefault(inWord, 0));
                if (flag1){
                    overload++;
                }
                cnt.merge(inWord, 1, Integer::sum);

                int left = right - windowLen;
                if (left < 0){
                    continue;
                }

                if (overload == 0){
                    ans.add(left);
                }

                String outWord = s.substring(left, left + wordLen);

                cnt.merge(outWord, -1, Integer::sum);
                boolean flag2 = cnt.get(outWord).equals(targetCnt.getOrDefault(outWord, 0));
                if (flag2){
                    overload--;
                }

            }
        }

        return ans;
     }
}
