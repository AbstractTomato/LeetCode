package Hash;

import java.util.*;


/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 */
public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){

        Map<String, List<String>> map = new HashMap<>();

        List<List<String>> ans = new ArrayList<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key  = new String(charArray);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
}
