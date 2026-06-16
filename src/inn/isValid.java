package inn;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class isValid {
    public boolean isValid1(String s){
        int length = s.length();
        if (length % 2 != 0){
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        for (int i = 0; i < length; i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
