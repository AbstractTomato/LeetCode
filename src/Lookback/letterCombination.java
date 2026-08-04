package Lookback;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class letterCombination {
    Map<Character, String> map;
    List<String> ans;
    public List<String> letterCombinations(String digits){
        if (digits == null || digits.isEmpty()){
            return List.of();
        }

        ans = new ArrayList<>();
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder builder = new StringBuilder();

        dfs(digits, 0, builder);

        return ans;
    }

    private void dfs(String digits, int index, StringBuilder builder){
        if (index == digits.length()){
            ans.add(builder.toString());
            return;
        }

        char letter = digits.charAt(index);
        String str = map.get(letter);
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            dfs(digits, index + 1, builder);
            builder.deleteCharAt(index);
        }
    }
}
