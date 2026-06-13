package Hash;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。具体来说：
 * pattern 中的每个字母都 恰好 映射到 s 中的一个唯一单词。
 * s 中的每个唯一单词都 恰好 映射到 pattern 中的一个字母。
 * 没有两个字母映射到同一个单词，也没有两个单词映射到同一个字母。
 */
public class wordPattern {
    public boolean wordPattern(String pattern, String s){

        String[] str = s.split(" ");
        if (str.length != pattern.length()){
            return false;
        }

        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            Character a = pattern.charAt(i);

            if (p2s.containsKey(a) && !p2s.get(a).equals(str[i]) ||
                    s2p.containsKey(str[i]) && s2p.get(str[i]) != a
            ){
                return false;
            }

            p2s.put(a, str[i]);
            s2p.put(str[i], a);
        }

        return true;
    }
}
