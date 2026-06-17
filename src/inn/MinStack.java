package inn;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int value) 将元素 value 推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class MinStack {

    /* 使用辅助栈 */
    /*private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        //先讲value放进栈中
        stack.push(value);

        //要维护最小栈里的栈顶元素,以满足getMin需求
        if (minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value);
        }
    }

    public void pop() {
        //如果删除的元素是栈中最小的元素,则要将最小栈中栈顶的元素删除,以便维护最小栈的栈顶是整个栈中的最小值
        Integer num = stack.pop();
        if (num.equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }*/

    /*-------------------------------------------------------------------------------------------------------------------*/

    /* 不使用辅助栈 */
    //栈中存当前要存入的值与最小值的差值,并且维护一个额外变量当前的最小值min
    private Deque<Long> deque;
    private long min;

    public MinStack(){
        deque = new ArrayDeque<>();
    }

    public void push(int value){
        if(deque.isEmpty()){
            //第一个元素
            deque.push(0L);
            min = value;
        }else {
            //如果不是第一个元素
            long diff = value - min;
            deque.push(diff);

            if (diff < 0){
                //表明此时要插入的元素更小,更新min
                min = value;
            }
        }
    }

    public void pop(){
        Long diff = deque.pop();

        if (diff < 0){
            //如果弹出的是最小值,则恢复最小值
            min = min - diff;
        }
    }

    public int top(){
        long diff = deque.peek();
        if (diff < 0){
            return (int)min;
        }else {
            return (int)(min + diff);
        }
    }

    public int getMin(){
        return (int)min;
    }
}
