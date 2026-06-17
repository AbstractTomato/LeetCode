package inn;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 */
public class evalRPN {
    public int evalRPN(String[] tokens){
        //遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            Character c = token.charAt(0);

            //如果是数字
            if (token.length() > 1 || Character.isDigit(c)){
                stack.push(Integer.parseInt(token));
                continue;
            }

            //如果是运算符
            //栈顶元素
            Integer top1 = stack.pop();
            Integer top2 = stack.pop();
            Integer num;
            switch (c){
                case '+' -> {
                    num = top1 + top2;
                    stack.push(num);
                    break;
                }
                case '-' -> {
                    num = top2 - top1;
                    stack.push(num);
                    break;
                }
                case '*' -> {
                    num = top1 * top2;
                    stack.push(num);
                    break;
                }
                case '/' -> {
                    num = top2 / top1;
                    stack.push(num);
                    break;
                }
            }
        }

        return stack.peek();
    }
}
