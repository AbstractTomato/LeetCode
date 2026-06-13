package Hash;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class isIsomorphic {
    public boolean isIsomorphic(String s, String t){
        Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (s2t.containsKey(a) && s2t.get(a) != b ||
            t2s.containsKey(b) && t2s.get(b) != a){
                return false;
            }
            s2t.put(a, b);
            t2s.put(b, a);
        }

        return true;
    }
}
